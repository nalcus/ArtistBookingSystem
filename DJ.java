public class DJ extends Artist {

    static int totalDJs; // M2 HOMEWORK STATIC
    EquipmentTypes equipmentType;

    DJ(String name, String style, int monthsExperience, EquipmentTypes equipmentType) {
        super(name, style, monthsExperience);
        this.equipmentType = equipmentType;
        totalDJs++;
    }

    public static void howManyDJs() { // M2 HOMEWORK STATIC
        System.out.println("There are " + totalDJs + " DJs");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tequipmentType=" + equipmentType;
    }

    public enum EquipmentTypes { // M2 HOMEWORK ENUM USE
        CDJS("CDJs"),
        VINYL("Vinyl"),
        LAPTOP("Laptop");

        private final String name;

        EquipmentTypes(String name) {
            this.name = name;
        }

        public final String toString() {
            return name;
        }
    }
}
