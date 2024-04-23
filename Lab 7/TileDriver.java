public class TileDriver{
    public static void main (String[] args){
    Tile obj = new Tile('z', 10);

    Tile.printTile(obj);

    Tile obj2 = new Tile('t',35);

    System.out.println(obj2);

    System.out.println(obj2.equals(obj));
}
}