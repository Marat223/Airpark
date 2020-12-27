package item;


public abstract class LandEnviroment implements Item {

    private int id;

    private LandEnviroment() {
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

}
