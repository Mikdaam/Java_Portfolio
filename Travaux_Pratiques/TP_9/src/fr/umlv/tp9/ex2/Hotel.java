package fr.umlv.tp9.ex2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public record Hotel(String name, List<Room> rooms) {
  public Hotel {
    Objects.requireNonNull(name, "Name can't be null");
    rooms = List.copyOf(rooms);
  }
  
  public String roomInfo() {
    return rooms.stream()
      .map(Room::name)
      .collect(Collectors.joining(", "));
  }
  
  public String roomInfoSortedByFloor() {
    return rooms.stream()
        .sorted(Comparator.comparingInt(Room::floor))
        .map(Room::name)
        .collect(Collectors.joining(", "));
  }
  
  public double averagePrice() {
    return rooms.stream()
        .mapToDouble(Room::price)
        .average()
        .orElse(Double.NaN);
  }
  
  public Optional<Room> roomForPrice1(long price) {
    return rooms.stream()
        .filter(room -> room.price() < price)
        .sorted(Comparator.comparingLong(Room::floor).reversed())
        .findFirst();
  }
  
  public Optional<Room> roomForPrice2(long price) {
    return rooms.stream()
        .filter(room -> room.price() < price)
        .max(Comparator.comparingLong(Room::price));
  }
  
  public static List<String> expensiveRoomNames(List<Hotel> hotels) {
    var hotelList = List.copyOf(hotels);
    return hotelList.stream()
        .flatMap(hotel -> hotel.rooms().stream()
            .sorted(Comparator.comparingLong(Room::price).reversed())
            .limit(2)            
            .map(Room::name)
         )
        .toList();
  }
  
  public Map<Integer, List<Room>> roomInfoGroupedByFloor() {
    return rooms.stream()
        .collect(Collectors.groupingBy(Room::floor, Collectors.toList()));
  }
  
  /* TODO: Ask the teacher an explanation*/
  public Map<Integer, List<Room>> roomInfoGroupedByFloorInOrder() {
    return rooms.stream()
        .collect(Collectors.groupingBy(Room::floor, TreeMap::new, Collectors.toList()));
  }
}
