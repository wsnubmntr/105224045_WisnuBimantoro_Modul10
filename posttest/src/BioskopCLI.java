import java.util.*;

public class BioskopCLI {

    public static void main(String[] args) {

        
        // MAP -> MENYIMPAN JADWAL FILM
       

        Map<String, Film> daftarFilm = new HashMap<>();

        daftarFilm.put("F01",
                new Film("F01", "Avengers Endgame", 50000));

        daftarFilm.put("F02",
                new Film("F02", "Interstellar", 45000));

        daftarFilm.put("F03",
                new Film("F03", "Pengabdi Setan", 40000));

        
        // SET -> MENYIMPAN KURSI YANG SUDAH DIPESAN
      

        Set<String> kursiTerpesan = new HashSet<>();

        
        // LIST -> MENYIMPAN RIWAYAT TRANSAKSI
       

        List<Transaksi> riwayatTransaksi = new ArrayList<>();

       
        // SIMULASI PEMESANAN
       

        prosesPemesanan(
                "Bagas",
                "F01",
                "A1",
                daftarFilm,
                kursiTerpesan,
                riwayatTransaksi
        );

        prosesPemesanan(
                "Toni",
                "F02",
                "B3",
                daftarFilm,
                kursiTerpesan,
                riwayatTransaksi
        );

        prosesPemesanan(
                "Pandi",
                "F01",
                "A1",
                daftarFilm,
                kursiTerpesan,
                riwayatTransaksi
        );

      
        // CETAK SELURUH RIWAYAT TRANSAKSI
       

        System.out.println("\n===== RIWAYAT PEMESANAN =====\n");

        for (Transaksi transaksi : riwayatTransaksi) {
            transaksi.tampilkanTransaksi();
        }
    }

    
    // METHOD PEMESANAN
   
    public static void prosesPemesanan(
            String namaPemesan,
            String kodeFilm,
            String nomorKursi,
            Map<String, Film> daftarFilm,
            Set<String> kursiTerpesan,
            List<Transaksi> riwayatTransaksi
    ) {

        System.out.println("Memproses pesanan "
                + namaPemesan + "...");

        
        // VALIDASI FILM
        

        if (!daftarFilm.containsKey(kodeFilm)) {

            System.out.println(
                    "Pemesanan gagal! Kode film tidak ditemukan.\n"
            );

            return;
        }

        
        // VALIDASI KURSI
        

        if (kursiTerpesan.contains(nomorKursi)) {

            System.out.println(
                    "Pemesanan gagal! Kursi "
                    + nomorKursi
                    + " sudah dipesan.\n"
            );

            return;
        }

        
        // AMBIL DATA FILM
        

        Film film = daftarFilm.get(kodeFilm);

       
        // SIMPAN KURSI KE SET
        

        kursiTerpesan.add(nomorKursi);

        
        // SIMPAN TRANSAKSI KE LIST
        

        Transaksi transaksiBaru =
                new Transaksi(
                        namaPemesan,
                        film.judul,
                        nomorKursi,
                        film.hargaTiket
                );

        riwayatTransaksi.add(transaksiBaru);

        System.out.println(
                "Pemesanan berhasil!\n"
        );
    }
}