package site.elven.plan.web.base.response;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuqs
 * @Date 2019/12/13 17:25
 */
public enum DefaultResponseResultCode implements ResultCodeable {

    SUCCESS_CODE("0000", "success"),
    UNKNOWN_EXCEPTION("9999", "unknown exception"),
    ;

    private String code;

    private String name;


    DefaultResponseResultCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getCodeByName(String name) {
        for (DefaultResponseResultCode item : DefaultResponseResultCode.values()) {
            if (item.getName().equals(name)) {
                return item.getCode();
            }
        }
        return null;
    }

    public static String getNameByCode(String code) {
        for (DefaultResponseResultCode item : DefaultResponseResultCode.values()) {
            if (item.getCode().equals(code)) {
                return item.getName();
            }
        }
        return null;
    }

    public static Map<String, String> getMapData() {
        HashMap<String, String> map = new HashMap<>();
        for (DefaultResponseResultCode item : DefaultResponseResultCode.values()) {
            map.put(item.getCode(), item.getName());
        }
        return map;
    }
}