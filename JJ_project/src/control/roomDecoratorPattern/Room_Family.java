package control.roomDecoratorPattern;


public class Room_Family extends Room {

    // must explicitly call super
    public Room_Family(I_Room i_room) {
        super(i_room);
    }

    @Override
    public double getCost()
    {
        return tempI_room.getCost() + 20.00; // cost differs
    }

    @Override
    public String getRoomType() {
        return "Family";
    }

}
