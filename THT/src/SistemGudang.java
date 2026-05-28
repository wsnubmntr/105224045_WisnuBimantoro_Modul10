import java.util.*;

public class SistemGudang {

    // =========================================
    // DATABASE BARANG
    // Key   = idBarang
    // Value = Objek Barang
    // =========================================
    Map<String, Barang> databaseBarang;

    // =========================================
    // KATEGORI UNIK
    // =========================================
    Set<String> kategoriUnik;

    // =========================================
    // RIWAYAT AKTIVITAS
    // =========================================
    List<String> riwayat;

    // =========================================
    // CONSTRUCTOR
    // =========================================
    public SistemGudang() {

        databaseBarang = new HashMap<>();

        kategoriUnik = new HashSet<>();

        riwayat = new ArrayList<>();
    }

    // =========================================
    // TAMBAH BARANG BARU
    // =========================================
    public void tambahBarangBaru(String id,
                                 String nama,
                                 String kategori,
                                 int stok) {

        Barang barangBaru =
                new Barang(id, nama, kategori, stok);

        // Simpan ke Map
        databaseBarang.put(id, barangBaru);

        // Simpan kategori ke Set
        kategoriUnik.add(kategori);

        // Simpan riwayat
        riwayat.add(
                "Barang baru ditambahkan : "
                + id
                + " - "
                + nama
        );

        System.out.println(
                "Barang berhasil ditambahkan!"
        );
    }

    // =========================================
    // TAMBAH STOK
    // =========================================
    public void tambahStok(String id,
                           int jumlah) {

        // Cek ID barang
        if (databaseBarang.containsKey(id)) {

            Barang barang =
                    databaseBarang.get(id);

            barang.stok += jumlah;

            riwayat.add(
                    "Stok barang "
                    + id
                    + " ditambah "
                    + jumlah
                    + " unit"
            );

            System.out.println(
                    "Tambah stok berhasil!"
            );

        } else {

            System.out.println(
                    "ID barang tidak ditemukan!"
            );
        }
    }

    // =========================================
    // KURANGI STOK
    // =========================================
    public void kurangiStok(String id,
                            int jumlah) {

        // Cek ID barang
        if (!databaseBarang.containsKey(id)) {

            System.out.println(
                    "ID barang tidak ditemukan!"
            );

            return;
        }

        Barang barang =
                databaseBarang.get(id);

        // Cek stok cukup atau tidak
        if (barang.stok >= jumlah) {

            barang.stok -= jumlah;

            riwayat.add(
                    "Stok barang "
                    + id
                    + " dikurangi "
                    + jumlah
                    + " unit"
            );

            System.out.println(
                    "Pengurangan stok berhasil!"
            );

        } else {

            riwayat.add(
                    "Gagal mengurangi stok "
                    + id
                    + " karena stok tidak cukup"
            );

            System.out.println(
                    "Stok tidak mencukupi!"
            );
        }
    }

    // =========================================
    // CETAK LAPORAN
    // =========================================
    public void cetakLaporan() {

        // =====================================
        // CETAK KATEGORI
        // =====================================
        System.out.println("\n===== KATEGORI =====");

        for (String kategori : kategoriUnik) {

            System.out.println("- " + kategori);
        }

        // =====================================
        // CETAK DATA BARANG
        // =====================================
        System.out.println("\n===== DATA BARANG =====");

        for (Barang barang : databaseBarang.values()) {

            System.out.println(
                    barang.idBarang
                    + " | "
                    + barang.namaBarang
                    + " | "
                    + barang.kategori
                    + " | Stok : "
                    + barang.stok
            );
        }

        // =====================================
        // CETAK RIWAYAT
        // =====================================
        System.out.println("\n===== RIWAYAT =====");

        for (String aktivitas : riwayat) {

            System.out.println(aktivitas);
        }
    }
}