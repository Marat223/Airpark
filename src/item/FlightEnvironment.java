package item;


public abstract class FlightEnvironment implements Item {

    private int id;
    private boolean isOnGround;

    private FlightEnvironment() {
    }

    @Override
    public void setId(int id) {
        this.id = id;
        isOnGround = true;
    }

    @Override
    public void doBusinessAction() {

    }
}
