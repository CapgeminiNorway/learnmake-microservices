package catpet.learnmake.jib.utils;

public final class AppConstants {

    public static final String BASE_PATH = "/";

    public static final String BUTTON_BACK = "_back";
    public static final String BUTTON_SUBMIT = "_submit";

    public static final String PARAM_FLASHATTR = "flashAttr";
    public static final String PARAM_REQORIGIN = "_req_origin";
    public static final String PARAM_ERRORATTR = "errorAttr";
    public static final String PARAM_EXPIREDSESSION = "_expired_session";

    public enum Type {
        ROUTE, ATTR
    }

    public enum Action {
        index, custom_action
    }

    public static String getIndex() {
        return getIndex("");
    }
    public static String getIndex(Type type) {
        return getIndex(type.name());
    }
    public static String getIndex(String type) {

        String result = Action.index.name();
        if (Type.ROUTE.name().equalsIgnoreCase(type)) {
            result = "/";
        }
        return result;
    }

    public static String getActionType(Action action) {
        return getActionType(action.name(), "");
    }
    public static String getActionType(String action) {
        return getActionType(action, "");
    }
    public static String getActionType(Action action, Type type) {
        return getActionType(action.name(), type.name());
    }
    public static String getActionType(String action, String type) {
        // e.g. getActionType("organization", "route") -> result = "/organization"

        String result = "";
        for (Action action1: Action.values()) {
            if (action1.name().equalsIgnoreCase(action)) {
                result = action1.name();
            }
        }

        if (Type.ROUTE.name().equalsIgnoreCase(type)) {
            result = BASE_PATH+"/" + result;
        }
        /*else if (Type.ATTR.name().equalsIgnoreCase(type)) {
            result = "ATTR_"+result;
        }*/

        return result;
    }
}
