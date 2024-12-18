package com.example.knifes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class KnifeService {

    public static List<Knife> knifes = Arrays.asList(
            new Knife(1, "Chef Knife", "8 inches", 4.5, 120, "Stainless Steel", 120.0),
            new Knife(2, "Paring Knife", "3.5 inches", 4.8, 85, "High-Carbon Steel", 50.0),
            new Knife(3, "Santoku Knife", "7 inches", 4.7, 95, "Damascus Steel", 150.0),
            new Knife(4, "Bread Knife", "9 inches", 4.6, 75, "Serrated Stainless Steel", 80.0),
            new Knife(5, "Utility Knife", "6 inches", 4.3, 60, "Ceramic", 40.0),
            new Knife(6, "Boning Knife", "5 inches", 4.4, 70, "High-Carbon Steel", 60.0),
            new Knife(7, "Cleaver", "7 inches", 4.9, 100, "Forged Steel", 200.0),
            new Knife(8, "Fillet Knife", "6 inches", 4.2, 55, "Stainless Steel", 70.0),
            new Knife(9, "Carving Knife", "10 inches", 4.5, 78, "High-Carbon Stainless Steel", 90.0),
            new Knife(10, "Nakiri Knife", "6.5 inches", 4.7, 90, "Japanese Steel", 130.0),
            new Knife(11, "Tomato Knife", "5 inches", 4.4, 50, "Serrated Steel", 35.0),
            new Knife(12, "Steak Knife", "5 inches", 4.5, 65, "Stainless Steel", 25.0),
            new Knife(13, "Meat Cleaver", "8 inches", 4.6, 80, "Carbon Steel", 110.0),
            new Knife(14, "Kitchen Shears", "6 inches", 4.8, 120, "Stainless Steel", 20.0),
            new Knife(15, "Oyster Knife", "3 inches", 4.2, 40, "Forged Steel", 45.0),
            new Knife(16, "Filleting Knife", "7 inches", 4.3, 50, "Flexible Steel", 75.0),
            new Knife(17, "Butcher Knife", "10 inches", 4.5, 90, "High-Carbon Steel", 100.0),
            new Knife(18, "Santoku Knife", "5 inches", 4.7, 95, "Ceramic", 55.0),
            new Knife(19, "Chef's Knife", "8 inches", 4.9, 105, "Japanese Stainless Steel", 160.0),
            new Knife(20, "Sashimi Knife", "11 inches", 4.6, 75, "High-Carbon Stainless Steel", 85.0),
            new Knife(21, "Vegetable Knife", "6 inches", 4.4, 60, "Stainless Steel", 30.0),
            new Knife(22, "Poultry Shears", "5.5 inches", 4.3, 55, "High-Carbon Steel", 25.0),
            new Knife(23, "Bread Knife", "7 inches", 4.7, 90, "Serrated Stainless Steel", 65.0),
            new Knife(24, "Chinese Cleaver", "6 inches", 4.8, 115, "Forged Steel", 125.0),
            new Knife(25, "Deba Knife", "6.5 inches", 4.5, 80, "Japanese Steel", 95.0),
            new Knife(26, "Nakiri Vegetable Knife", "6 inches", 4.4, 70, "Damascus Steel", 115.0),
            new Knife(27, "Petty Knife", "4 inches", 4.3, 50, "Stainless Steel", 40.0),
            new Knife(28, "Usuba Knife", "6.5 inches", 4.6, 85, "High-Carbon Steel", 140.0),
            new Knife(29, "Peeling Knife", "2.5 inches", 4.2, 35, "Forged Steel", 35.0),
            new Knife(30, "Honesuki Knife", "5 inches", 4.8, 100, "Japanese Steel", 150.0),
            new Knife(31, "Pasta Knife", "6 inches", 4.5, 75, "Stainless Steel", 90.0),
            new Knife(32, "Salmon Knife", "12 inches", 4.7, 95, "Flexible Stainless Steel", 200.0),
            new Knife(33, "Kiritsuke Knife", "8 inches", 4.9, 110, "Damascus Steel", 175.0),
            new Knife(34, "Butter Knife", "4 inches", 4.3, 50, "Stainless Steel", 15.0),
            new Knife(35, "Crinkle-Cut Knife", "5 inches", 4.4, 55, "High-Carbon Steel", 45.0),
            new Knife(36, "Granton Slicer", "10 inches", 4.6, 75, "Stainless Steel", 80.0),
            new Knife(37, "Boning Hook Knife", "6 inches", 4.7, 90, "Forged Steel", 105.0),
            new Knife(38, "Herb Chopper", "5 inches", 4.3, 50, "Ceramic", 35.0),
            new Knife(39, "Lobster Knife", "6 inches", 4.5, 70, "Stainless Steel", 120.0),
            new Knife(40, "Gyuto Knife", "8 inches", 4.8, 100, "High-Carbon Stainless Steel", 210.0),
            new Knife(41, "Mincing Knife", "7 inches", 4.4, 60, "Carbon Steel", 85.0),
            new Knife(42, "Vegetable Cleaver", "8 inches", 4.7, 95, "Forged Steel", 130.0),
            new Knife(43, "Carving Fork", "6 inches", 4.2, 40, "Stainless Steel", 25.0),
            new Knife(44, "Honing Knife", "5 inches", 4.5, 65, "High-Carbon Steel", 50.0),
            new Knife(45, "Butterfly Knife", "4 inches", 4.6, 80, "Damascus Steel", 75.0),
            new Knife(46, "Whittling Knife", "3 inches", 4.3, 45, "Forged Steel", 40.0),
            new Knife(47, "Slicing Knife", "10 inches", 4.8, 100, "Flexible Steel", 100.0),
            new Knife(48, "Baguette Knife", "11 inches", 4.5, 70, "Serrated Steel", 90.0),
            new Knife(49, "Bushcraft Knife", "5 inches", 4.6, 80, "Carbon Steel", 60.0),
            new Knife(50, "Fishing Knife", "6 inches", 4.4, 55, "Stainless Steel", 55.0),
            new Knife(51, "Game Processing Knife", "5 inches", 4.7, 90, "High-Carbon Steel", 80.0),
            new Knife(52, "Camp Knife", "7 inches", 4.9, 110, "Forged Steel", 120.0),
            new Knife(53, "Survival Knife", "9 inches", 4.8, 100, "Stainless Steel", 110.0),
            new Knife(54, "Marine Knife", "4 inches", 4.5, 70, "Corrosion-Resistant Steel", 65.0),
            new Knife(55, "Dive Knife", "5 inches", 4.6, 80, "Titanium", 130.0),
            new Knife(56, "Bush Knife", "6 inches", 4.2, 40, "Carbon Steel", 40.0),
            new Knife(57, "Chef's Specialty Knife", "7.5 inches", 4.8, 110, "High-Carbon Stainless Steel", 160.0),
            new Knife(58, "Vegetable Paring Knife", "4 inches", 4.4, 65, "Ceramic", 45.0),
            new Knife(59, "Heavy Duty Cleaver", "10 inches", 4.7, 120, "Forged Steel", 180.0),
            new Knife(60, "Professional Santoku Knife", "6.5 inches", 4.9, 130, "Damascus Steel", 175.0),
            new Knife(61, "Serrated Tomato Knife", "4.5 inches", 4.5, 60, "Serrated Steel", 30.0),
            new Knife(62, "Offset Bread Knife", "8 inches", 4.6, 90, "Stainless Steel", 75.0),
            new Knife(63, "Precision Fillet Knife", "7 inches", 4.8, 100, "Flexible Stainless Steel", 95.0),
            new Knife(64, "Heavy Chef Knife", "9 inches", 4.7, 110, "High-Carbon Steel", 140.0),
            new Knife(65, "Boning Knife XL", "6 inches", 4.4, 80, "Forged Steel", 65.0),
            new Knife(66, "Japanese Paring Knife", "3.5 inches", 4.5, 75, "Japanese Steel", 55.0),
            new Knife(67, "Compact Cleaver", "5 inches", 4.3, 50, "Carbon Steel", 50.0),
            new Knife(68, "Vintage Carving Knife", "10 inches", 4.6, 85, "High-Carbon Steel", 100.0),
            new Knife(69, "Petite Santoku Knife", "5 inches", 4.4, 60, "Ceramic", 45.0),
            new Knife(70, "Compact Chef Knife", "6 inches", 4.5, 70, "High-Carbon Stainless Steel", 90.0),
            new Knife(71, "Sushi Knife", "10.5 inches", 4.8, 95, "Japanese Steel", 160.0),
            new Knife(72, "Cleaver Pro", "8 inches", 4.9, 125, "Forged Steel", 200.0),
            new Knife(73, "Multifunctional Utility Knife", "6.5 inches", 4.6, 80, "Stainless Steel", 65.0),
            new Knife(74, "Long Reach Bread Knife", "10 inches", 4.7, 100, "Serrated Stainless Steel", 85.0),
            new Knife(75, "Ergonomic Fillet Knife", "6 inches", 4.5, 65, "Flexible Steel", 70.0),
            new Knife(76, "Ultra-Light Chef Knife", "8 inches", 4.6, 90, "Titanium", 150.0),
            new Knife(77, "Professional Meat Cleaver", "7 inches", 4.8, 110, "High-Carbon Steel", 120.0),
            new Knife(78, "Slim Boning Knife", "5 inches", 4.3, 60, "Forged Steel", 55.0),
            new Knife(79, "Herb Mincing Knife", "5 inches", 4.5, 70, "Ceramic", 35.0),
            new Knife(80, "Paring Knife Deluxe", "4 inches", 4.7, 80, "Damascus Steel", 60.0),
            new Knife(81, "Sturdy Camp Knife", "9 inches", 4.6, 95, "Forged Steel", 115.0),
            new Knife(82, "All-Purpose Kitchen Knife", "8 inches", 4.4, 75, "Stainless Steel", 80.0),
            new Knife(83, "Precision Sushi Knife", "11 inches", 4.9, 105, "Japanese Stainless Steel", 185.0),
            new Knife(84, "Flexible Boning Knife", "6 inches", 4.2, 55, "High-Carbon Steel", 50.0),
            new Knife(85, "Heavy Duty Butcher Knife", "12 inches", 4.8, 115, "Carbon Steel", 145.0),
            new Knife(86, "Crinkle Potato Knife", "5.5 inches", 4.3, 60, "Stainless Steel", 25.0),
            new Knife(87, "Premium Tomato Knife", "4.5 inches", 4.6, 75, "Serrated Steel", 40.0),
            new Knife(88, "Compact Santoku Knife", "4.5 inches", 4.4, 50, "Ceramic", 35.0),
            new Knife(89, "Marine Chef Knife", "6 inches", 4.5, 70, "Corrosion-Resistant Steel", 75.0),
            new Knife(90, "Heavy Duty Survival Knife", "10 inches", 4.8, 105, "Titanium", 160.0),
            new Knife(91, "Precision Peeling Knife", "2 inches", 4.3, 45, "Forged Steel", 30.0),
            new Knife(92, "Miniature Cleaver", "4 inches", 4.5, 60, "Carbon Steel", 45.0),
            new Knife(93, "Serrated Steak Knife", "5 inches", 4.6, 80, "Stainless Steel", 35.0),
            new Knife(94, "Pro Sushi Knife", "12 inches", 4.9, 115, "Japanese Steel", 200.0),
            new Knife(95, "Compact Herb Chopper", "4 inches", 4.3, 50, "Ceramic", 30.0),
            new Knife(96, "Flexible Fillet Knife", "7 inches", 4.5, 70, "Flexible Stainless Steel", 80.0),
            new Knife(97, "Multi-Blade Kitchen Shears", "6.5 inches", 4.8, 125, "Stainless Steel", 40.0),
            new Knife(98, "Versatile Vegetable Knife", "5 inches", 4.4, 60, "High-Carbon Steel", 50.0),
            new Knife(99, "Expert Butcher Knife", "9 inches", 4.7, 100, "High-Carbon Stainless Steel", 135.0),
            new Knife(100, "Ultra-Sharp Chef's Knife", "8 inches", 4.9, 120, "Damascus Steel", 210.0)

    );

    public static List<KnifeDto> getAllKnives(FilterRequestDto filterRequestDto, String sortMode) {
        List<Knife> knifeList = knifes;


        if (filterRequestDto.price() != null) {
            knifeList = knifeList
                    .stream()
                    .filter(knife -> knife.price() <= filterRequestDto.price().max())
                    .filter(knife -> knife.price() >= filterRequestDto.price().min())
                    .toList();
        }

        if (filterRequestDto.manufacturer() != null) {
            knifeList = knifeList
                    .stream()
                    .filter(knife -> Objects.equals(knife.manufacturer(), filterRequestDto.manufacturer()))
                    .toList();
        }

        if (filterRequestDto.steel() != null) {
            knifeList = knifeList
                    .stream()
                    .filter(knife -> Objects.equals(knife.steelGrade(), filterRequestDto.steel()))
                    .toList();
        }


        if (filterRequestDto.handle() != null) {
            knifeList = knifeList
                    .stream()
                    .filter(knife -> Objects.equals(knife.handle(), filterRequestDto.handle()))
                    .toList();
        }

        if (filterRequestDto.guard() != null) {
            knifeList = knifeList
                    .stream()
                    .filter(knife -> Objects.equals(knife.guard(), filterRequestDto.guard()))
                    .toList();
        }

        if (filterRequestDto.totalLength() != null) {
            knifeList = knifeList
                    .stream()
                    .filter(knife -> knife.overallLength() <= filterRequestDto.totalLength().max())
                    .filter(knife -> knife.overallLength() >= filterRequestDto.totalLength().min())
                    .toList();
        }

        if (filterRequestDto.bladeLength() != null) {
            knifeList = knifeList
                    .stream()
                    .filter(knife -> knife.bladeLength() <= filterRequestDto.bladeLength().max())
                    .filter(knife -> knife.bladeLength() >= filterRequestDto.bladeLength().min())
                    .toList();
        }

        if (filterRequestDto.bladeWidth() != null) {
            knifeList = knifeList
                    .stream()
                    .filter(knife -> knife.bladeWidth() <= filterRequestDto.bladeWidth().max())
                    .filter(knife -> knife.bladeWidth() >= filterRequestDto.bladeWidth().min())
                    .toList();
        }

        if (filterRequestDto.rating() != null) {
            knifeList = knifeList
                    .stream()
                    .filter(knife -> knife.rating() >= filterRequestDto.rating())
                    .toList();
        }

        knifeList = switch (sortMode) {
            case "rating" -> knifeList
                    .stream()
                    .sorted(Comparator.comparing(Knife::rating).reversed())
                    .toList();
            case "price" -> knifeList
                    .stream()
                    .sorted(Comparator.comparing(Knife::price).reversed())
                    .toList();
            default -> knifeList
                    .stream()
                    .sorted(Comparator.comparing(Knife::questioners).reversed())
                    .toList();
        };


        return knifeList.stream()
                .map(KnifeService::parseKnifeToDto)
                .toList();
    }

    public static Map<String, Object> loadOptions() {
        Map<String, Object> options = new HashMap<>();
        Map<String, Double> priceMap = new HashMap<>();

        priceMap.put("min", getMinPrice());
        priceMap.put("max", getMaxPrice());
        options.put("price", priceMap);

        // Count manufacturers
        Map<String, Long> manufacturerCount = knifes.stream()
                .collect(Collectors.groupingBy(Knife::manufacturer, Collectors.counting()));
        List<Map<String, Object>> manufacturesList = manufacturerCount.entrySet().stream()
                .map(entry -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", entry.getKey());
                    map.put("count", entry.getValue());
                    return map;
                })
                .collect(Collectors.toList());
        options.put("manufactures", manufacturesList);

        // Count steel grades
        Map<String, Long> steelCount = knifes.stream()
                .collect(Collectors.groupingBy(Knife::steelGrade, Collectors.counting()));
        List<Map<String, Object>> steelList = steelCount.entrySet().stream()
                .map(entry -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", entry.getKey());
                    map.put("count", entry.getValue());
                    return map;
                })
                .collect(Collectors.toList());
        options.put("steels", steelList);

        // Count handles
        Map<String, Long> handleCount = knifes.stream()
                .collect(Collectors.groupingBy(Knife::handle, Collectors.counting()));
        List<Map<String, Object>> handlesList = handleCount.entrySet().stream()
                .map(entry -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", entry.getKey());
                    map.put("count", entry.getValue());
                    return map;
                })
                .collect(Collectors.toList());
        options.put("handles", handlesList);

        // Count guards
        Map<String, Long> guardCount = knifes.stream()
                .collect(Collectors.groupingBy(Knife::guard, Collectors.counting()));
        List<Map<String, Object>> guardsList = guardCount.entrySet().stream()
                .map(entry -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", entry.getKey());
                    map.put("count", entry.getValue());
                    return map;
                })
                .collect(Collectors.toList());
        options.put("guards", guardsList);

        // Overall length
        Map<String, Double> overallLengthMap = new HashMap<>();
        overallLengthMap.put("min", Arrays.stream(Knife.overallLengths).min().orElse(0.00));
        overallLengthMap.put("max", Arrays.stream(Knife.overallLengths).max().orElse(0.00));
        options.put("totalLength", overallLengthMap);

        // Blade width
        Map<String, Double> bladeWidthMap = new HashMap<>();
        bladeWidthMap.put("min", 2.00);
        bladeWidthMap.put("max", 10.00);
        options.put("bladeWidth", bladeWidthMap);

        // Blade lengths
        Map<String, Double> bladeLengthsMap = new HashMap<>();
        bladeLengthsMap.put("min", Arrays.stream(Knife.bladeLengths).min().orElse(0.00));
        bladeLengthsMap.put("max", Arrays.stream(Knife.bladeLengths).max().orElse(0.00));
        options.put("bladeLength", bladeLengthsMap);

        return options;
    }


    public static Knife getKnifeById(int id) {
        return knifes.stream().filter(knife -> knife.id() == id)
                .findAny().orElse(null);
    }


    public static KnifeDetailDto getKnifeDtoById(int id) {
        return parseKnifeToDetailDto(Objects.requireNonNull(knifes.stream().filter(knife -> knife.id() == id)
                .findAny().orElse(null)));
    }



//    help methods

    private static Double getMinPrice() {
        var minPrice = knifes.stream().min(Comparator.comparing(Knife::price))
                .map(Knife::price)
                .stream().findAny();

        return minPrice.orElse(0.00);
    }

    private static Double getMaxPrice() {
        var minPrice = knifes.stream().max(Comparator.comparing(Knife::price))
                .map(Knife::price)
                .stream().findAny();

        return minPrice.orElse(0.00);
    }

    private static KnifeDto parseKnifeToDto(Knife knife) {
        return new KnifeDto(
                knife.id(),
                knife.imageUrl(),
                knife.name(),
                knife.size(),
                knife.material(),
                knife.rating(),
                knife.questioners(),
                knife.price());
    }

    private static KnifeDetailDto parseKnifeToDetailDto(Knife knife) {
        return new KnifeDetailDto(
                knife.id(),
                knife.imageUrl(),
                knife.name(),
                knife.size(),
                knife.material(),
                knife.rating(),
                knife.questioners(),
                knife.price(),
                knife.category(),
                knife.knifeWorkshop(),
                knife.sharpeningAndPolishing(),
                knife.buttCap());
    }

}
