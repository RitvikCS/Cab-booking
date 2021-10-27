package bphc.taxidriver.models;

public enum Location {//enum is used to declare objects of set named values(collection of constants)
    Location1(0, "Location 1"), Location2(1, "Location 2"), Location3(2, "Location 3");
    
    private int index;
    private String readableName;
    
    private Location(int index, String readableName) {
        this.index = index;
        this.readableName = readableName;
    }
    
    public static Location fromIndex(int i) {
        for (Location c : Location.values()) {
            if (c.index == i)
                return c;
        }
        return null;
    }
    
    @Override
    public String toString() {
        return readableName;
    }
    
    public int getIndex() {
        return index;
    }
}
