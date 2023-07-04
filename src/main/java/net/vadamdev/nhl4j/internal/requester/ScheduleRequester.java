package net.vadamdev.nhl4j.internal.requester;

import net.vadamdev.nhl4j.api.NHLGameState;
import net.vadamdev.nhl4j.api.TeamData;
import net.vadamdev.nhl4j.api.entities.Game;
import net.vadamdev.nhl4j.api.entities.Schedule;
import net.vadamdev.nhl4j.internal.impl.GameImpl;
import net.vadamdev.nhl4j.internal.impl.ScheduleImpl;
import net.vadamdev.nhl4j.internal.impl.TeamImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author VadamDev
 * @since 22/11/2022
 */
public class ScheduleRequester {
    private static final DateFormat API_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Supplier<Schedule> request(Date date) {
        final String strUrl = "https://statsapi.web.nhl.com/api/v1/schedule" + (date != null ? "?date=" + API_DATE_FORMAT.format(date) : "");

        return () -> {
            try {
                InputStream stream = new URL(strUrl).openConnection().getInputStream();
                String text = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));

                JSONObject jsonDates = (JSONObject) ((JSONArray) ((JSONObject) new JSONParser().parse(text)).get("dates")).get(0);
                JSONArray jsonGames = (JSONArray) jsonDates.get("games");

                List<Game> games = new ArrayList<>();
                for (int i = 0; i < jsonGames.size(); i++) {
                    JSONObject jsonGame = (JSONObject) jsonGames.get(i);
                    JSONObject teams = (JSONObject) jsonGame.get("teams");

                    TeamData[] teamData = new TeamData[] {
                            getTeamDataFromJson((JSONObject) teams.get("away")),
                            getTeamDataFromJson((JSONObject) teams.get("home"))
                    };

                    games.add(new GameImpl(
                            teamData,
                            NHLGameState.fromString((String) ((JSONObject) jsonGame.get("status")).get("abstractGameState")),
                            /*TEAM_DATE_FORMAT.parse((String) jsonGame.get("gameDate"))*/null,
                            (long) jsonGame.get("gamePk")
                    ));
                }

                return new ScheduleImpl(games, API_DATE_FORMAT.parse((String) jsonDates.get("date")));
            }catch (IOException | ParseException | java.text.ParseException e) {
                e.printStackTrace();
                return null;
            }
        };
    }

    private static TeamData getTeamDataFromJson(JSONObject jsonTeam) {
        return new TeamData(
                new TeamImpl((String) ((JSONObject) jsonTeam.get("team")).get("name"), (long) ((JSONObject) jsonTeam.get("team")).get("id")),
                (long) jsonTeam.get("score")
        );
    }
}
