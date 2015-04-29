package control.roomDecoratorPattern;


public class Room_Single extends Room {

    // must explicitly call super
    public Room_Single(I_Room i_room) {
        super(i_room);
    }

    @Override
    public double getCost()
    {
        return tempI_room.getCost() + 10.00; // cost differs
    }


    @Override
    public String getRoomType() {
        return "Single";
    }

}
