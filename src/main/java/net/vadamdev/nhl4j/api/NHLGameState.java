package net.vadamdev.nhl4j.api;

/**
 * @author VadamDev
 * @since 22/11/2022
 */
public enum NHLGameState {
    PREVIEW, LIVE, FINAL;

    public static NHLGameState fromString(String str) {
        switch(str) {
            case "Preview":
                return PREVIEW;
            case "Live":
                return LIVE;
            case "Final":
                return FINAL;
            default:
                return null;
        }
    }
}
