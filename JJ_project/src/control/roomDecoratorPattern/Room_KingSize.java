package control.roomDecoratorPattern;


public class Room_KingSize extends Room {

    // must explicitly call super
    public Room_KingSize(I_Room i_room) {
        super(i_room);
    }

    @Override
    public double getCost()
    {
        return tempI_room.getCost() + 40.00; // cost differs
    }


    @Override
    public String getRoomType() {
        return "King";
    }
}
