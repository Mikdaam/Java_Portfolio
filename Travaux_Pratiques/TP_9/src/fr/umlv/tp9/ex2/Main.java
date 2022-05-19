package fr.umlv.tp9.ex2;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    var hotel = new Hotel("paradisio", List.of(
        new Room("blue", 100, 100),
        new Room("yellow", 110, 200),
        new Room("fuchsia", 120, 300),
        new Room("red", 100, 200),
        new Room("green", 100, 200)
    ));
    
    System.out.println("======ROOM INFO=======");
    System.out.println(hotel.roomInfo());
    
    System.out.println("======ROOM INFO (SORTED BY FLOOR)========");
    System.out.println(hotel.roomInfoSortedByFloor());
    
    System.out.println("=========ROOM PRICE AVVERAGE=================");
    System.out.println(hotel.averagePrice());
    
    System.out.println("============ROOM FOR PRICE(1)=================");
    System.out.println(hotel.roomForPrice1(250));
    
    System.out.println("============ROOM FOR PRICE(2)=================");
    System.out.println(hotel.roomForPrice2(250));
    
    var hotel2 = new Hotel("fantastico", List.of(
        new Room("queen", 1, 200),
        new Room("king", 1, 500)
    ));
    
    System.out.println("============ EXPENSIVE ROOMS =================");
    System.out.println(Hotel.expensiveRoomNames(List.of(hotel, hotel2)));
    
    System.out.println("============ FLOOR INFO =================");
    System.out.println(hotel.roomInfoGroupedByFloor());
    
    System.out.println("============ FLOOR INFO (ORDERED) =================");
    System.out.println(hotel.roomInfoGroupedByFloorInOrder());
  }
}
