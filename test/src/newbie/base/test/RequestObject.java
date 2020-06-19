package newbie.base.test;

import java.util.Map;

public class RequestObject {

    private Map map;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void addMapValue(String key, Object value) {
        getMap().put(key, value);
    }
}
