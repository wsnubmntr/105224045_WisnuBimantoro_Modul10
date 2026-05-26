import java.util.*;

public class PreTestKedaiKopi {
    public static void main(String[] args) {

        // TODO 1
        List<String> antrean = new ArrayList<>();

        // TODO 2
        Set<Integer> mejaTerisi = new HashSet<>();

        // TODO 3
        Map<String, Integer> hargaMenu = new HashMap<>();

        // === Simulasi ===
        antrean.add("wisnu");
        antrean.add("bima");

        mejaTerisi.add(4);
        mejaTerisi.add(7);
        mejaTerisi.add(4);

        hargaMenu.put("Kopi", 15000);
        hargaMenu.put("Teh", 10000);

        System.out.println("Daftar Antrean  : " + antrean);
        System.out.println("Meja Terisi     : " + mejaTerisi);
        System.out.println("Harga Kopi      : Rp " + hargaMenu.get("Kopi"));
    }
}