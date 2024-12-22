package com.example.knifes.domain;

import java.util.Random;

public class Knife {
    private int id;
    private String name;
    private String size;
    private double rating;
    private int questioners;
    private String material;
    private double price;
    private String imageUrl;
    private String category;
    private String manufacturer;
    private String steelGrade;
    private String sharpeningAndPolishing;
    private String knifeWorkshop;
    private double bladeWidth;
    private double bladeLength;
    private String guard;
    private String buttCap;
    private String handle;
    private double overallLength; // New field for overall length

    private static final String[] categories = {"Tourist", "Hunting", "Bulat", "Damascus", "Processing", "Tactical", "Throwing", "Machete and Kukri", "Kitchen"};
    public static final String[] manufacturers = {"BladeCraft", "SteelMaster", "SharpEdge", "ForgeWorks", "KnifeCo", "HuntBlades", "TacticalSteel", "EliteForge", "RazorSmiths", "EdgeCraft"};
    public static final String[] steelGrades = {"40x102c2m", "95x8", "100x13", "110x18"};
    private static final String[] sharpeningAndPolishingMethods = {"GOI Paste", "Diamond Paste", "Sharpening Stones", "Sharpening Systems"};
    private static final String[] knifeWorkshopOptions = {"Knife Workshop", "Blanks for Knives", "Knife Casting", "Handle Materials", "Handle Care"};
    private static final String[] imageUrls = {
            "https://cdn.sanity.io/images/fr9flhkd/main/0f0911c4dbe2920dd2699cf252d33510d323b8cf-1500x1500.jpg?fm=webp&q=75&w=1280",
            "https://cdn11.bigcommerce.com/s-43l4b17cyb/images/stencil/1280w/products/608/8171/F041TN-CP_product_alt_5__78873__11941.1579023102.jpg?c=2",
            "https://www.huntingandknives.co.uk/pub/media/catalog/product/cache/459300f1b5bd3c38ffb32210b0c2c42e/s/e/set-of-2-third-h7125-blue-throwing-knives.jpg",
            "https://www.huntingandknives.co.uk/pub/media/catalog/product/cache/459300f1b5bd3c38ffb32210b0c2c42e/s/e/set-of-2-third-h7125-blue-throwing-knives.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTjddpwsVcntmsuWyc_nw4yinsPnPi_yCviw&s",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTjddpwsVcntmsuWyc_nw4yinsPnPi_yCviw&s",
            "https://www.swiss-knife.com/media/catalog/product/cache/7adce2c7f898670e8b9c2115b1d83238/p/k/pk-11a-best-of-switzerland_def.jpg",
            "https://cdn11.bigcommerce.com/s-43l4b17cyb/images/stencil/1280w/products/608/8171/F041TN-CP_product_alt_5__78873__11941.1579023102.jpg?c=2",
            "https://cdn.sanity.io/images/fr9flhkd/main/397a12dce06c63bcb33cc4774bcd412095ccedb4-1500x1500.jpg?fm=webp&q=75&w=1280",
            "https://cdn11.bigcommerce.com/s-46csjp/images/stencil/1280x1280/products/7132/35384/TTK-H6W-Hunting-Camp-Knife__32019.1674105348.jpg?c=2",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyQHa8LHlX_dq8TDu557zag9dm91I6iAiPzA&s",
            "https://frontierblades.com/cdn/shop/products/57_f8f08337-8fea-4478-b69a-522f78075794_1200x1200.jpg?v=1579887164"
    };
    public static final double[] bladeWidths = {2.50, 3.00, 3.50, 4.00, 4.50};
    public static final double[] bladeLengths = {10.00, 12.00, 15.00, 18.00, 20.00};
    public static final double[] overallLengths = {20.00, 25.00, 30.00, 35.00, 40.00};
    public static final String[] guards = {"Aluminum", "Brass", "Lithium", "Steel", "Titanium"};
    public static final String[] buttCaps = {"Steel Cap", "Aluminum Cap", "Wooden Cap", "No Cap"};
    public static final String[] handles = {"Wood", "Micarta", "Rubber", "Bone", "G10"};

    public Knife(int id, String name, String size, double rating, int questioners, String material, double price) {
        Random random = new Random();

        this.id = id;
        this.name = name;
        this.size = size;
        this.rating = rating;
        this.questioners = questioners;
        this.material = material;
        this.price = price;
        this.imageUrl = imageUrls[random.nextInt(imageUrls.length)];
        this.category = categories[random.nextInt(categories.length)];
        this.manufacturer = manufacturers[random.nextInt(manufacturers.length)];
        this.steelGrade = steelGrades[random.nextInt(steelGrades.length)];
        this.sharpeningAndPolishing = sharpeningAndPolishingMethods[random.nextInt(sharpeningAndPolishingMethods.length)];
        this.knifeWorkshop = knifeWorkshopOptions[random.nextInt(knifeWorkshopOptions.length)];
        this.bladeWidth = bladeWidths[random.nextInt(bladeWidths.length)];
        this.bladeLength = bladeLengths[random.nextInt(bladeLengths.length)];
        this.guard = guards[random.nextInt(guards.length)];
        this.buttCap = buttCaps[random.nextInt(buttCaps.length)];
        this.handle = handles[random.nextInt(handles.length)];
        this.overallLength = overallLengths[random.nextInt(overallLengths.length)]; // Set overall length
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String size() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double rating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int questioners() {
        return questioners;
    }

    public void setQuestioners(int questioners) {
        this.questioners = questioners;
    }

    public String material() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double price() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String imageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String category() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String manufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String steelGrade() {
        return steelGrade;
    }

    public void setSteelGrade(String steelGrade) {
        this.steelGrade = steelGrade;
    }

    public String sharpeningAndPolishing() {
        return sharpeningAndPolishing;
    }

    public void setSharpeningAndPolishing(String sharpeningAndPolishing) {
        this.sharpeningAndPolishing = sharpeningAndPolishing;
    }

    public String knifeWorkshop() {
        return knifeWorkshop;
    }

    public void setKnifeWorkshop(String knifeWorkshop) {
        this.knifeWorkshop = knifeWorkshop;
    }

    public double bladeWidth() {
        return bladeWidth;
    }

    public void setBladeWidth(double bladeWidth) {
        this.bladeWidth = bladeWidth;
    }

    public double bladeLength() {
        return bladeLength;
    }

    public void setBladeLength(double bladeLength) {
        this.bladeLength = bladeLength;
    }

    public String guard() {
        return guard;
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }

    public String buttCap() {
        return buttCap;
    }

    public void setButtCap(String buttCap) {
        this.buttCap = buttCap;
    }

    public String handle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public double overallLength() {
        return overallLength;
    }

    public void setOverallLength(double overallLength) {
        this.overallLength = overallLength;
    }
}
