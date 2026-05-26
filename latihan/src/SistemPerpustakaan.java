import java.util.*;

public class SistemPerpustakaan {

    public static void main(String[] args) {

        // SOAL 1
        Map<String, Buku> katalogBuku = new HashMap<>();

        katalogBuku.put("B001", new Buku("B001", "Laskar Pelangi"));
        katalogBuku.put("B002", new Buku("B002", "Bumi Manusia"));
        katalogBuku.put("B003", new Buku("B003", "Atomic Habits"));

        // SOAL 2
        Set<Anggota> daftarAnggota = new HashSet<>();

        daftarAnggota.add(new Anggota("A01", "Budi", "Mahasiswa"));
        daftarAnggota.add(new Anggota("A02", "Siti", "Dosen"));
        daftarAnggota.add(new Anggota("A03", "Andi", "Mahasiswa"));

        boolean status =
                daftarAnggota.add(
                        new Anggota("A01", "Budi Baru", "Dosen")
                );

        System.out.println("Status input duplikat : " + status);

        // SOAL 3
        LinkedList<String> antrean = new LinkedList<>();

        antrean.addLast("A01#B001");
        antrean.addFirst("A02#B002");
        antrean.addLast("A03#B003");
        antrean.addFirst("A02#B001");

        // SOAL 4
        Set<String> bukuDipinjam = new HashSet<>();

        while (!antrean.isEmpty()) {

            String data = antrean.removeFirst();

            String[] hasil = data.split("#");

            String idAnggota = hasil[0];
            String isbn = hasil[1];

            boolean anggotaValid = false;

            for (Anggota anggota : daftarAnggota) {

                if (anggota.idAnggota.equals(idAnggota)) {
                    anggotaValid = true;
                    break;
                }
            }

            boolean bukuValid = katalogBuku.containsKey(isbn);

            boolean sedangDipinjam =
                    bukuDipinjam.contains(isbn);

            if (!anggotaValid) {

                System.out.println(
                        "Gagal: anggota tidak terdaftar"
                );

            } else if (!bukuValid) {

                System.out.println(
                        "Gagal: ISBN tidak ditemukan"
                );

            } else if (sedangDipinjam) {

                System.out.println(
                        "Gagal: buku sedang dipinjam"
                );

            } else {

                bukuDipinjam.add(isbn);

                System.out.println(
                        "Berhasil: " +
                        idAnggota +
                        " meminjam " +
                        isbn
                );
            }
        }
    }
}