public class Main {

    public static void main(String[] args) {

        // Membuat objek SistemGudang
        SistemGudang gudang =
                new SistemGudang();

        // =====================================
        // TAMBAH BARANG BARU
        // =====================================

        gudang.tambahBarangBaru(
                "01",
                "Laptop",
                "Elektronik",
                10
        );

        gudang.tambahBarangBaru(
                "02",
                "Mouse",
                "Elektronik",
                20
        );

        gudang.tambahBarangBaru(
                "03",
                "Meja",
                "Furniture",
                5
        );

        // =====================================
        // TAMBAH STOK BERHASIL
        // =====================================

        gudang.tambahStok(
                "01",
                5
        );

        // =====================================
        // KURANGI STOK BERHASIL
        // =====================================

        gudang.kurangiStok(
                "02",
                10
        );

        // =====================================
        // KURANGI STOK GAGAL
        // =====================================

        gudang.kurangiStok(
                "03",
                20
        );

        // =====================================
        // CETAK LAPORAN
        // =====================================

        gudang.cetakLaporan();
    }
}