# Sistem Informasi Pengelolaan Perikanan

## 1. Deskripsi Singkat Program

Sistem Informasi Pengelolaan Perikanan merupakan program berbasis Java yang dibuat untuk membantu pengelolaan data perikanan menggunakan database MySQL. Program ini memiliki fitur untuk mengelola data ikan, lokasi penangkapan, dan hasil penangkapan. Pengguna dapat menambahkan, menampilkan, mengubah, dan menghapus data melalui menu yang tersedia. Program ini menerapkan konsep Object-Oriented Programming (OOP) serta menggunakan JDBC untuk menghubungkan program dengan database.

## 2. Penjelasan Struktur Package

Program terdiri dari beberapa package yang digunakan untuk mengelompokkan kelas berdasarkan fungsinya.

- `main`  
  Berisi kelas `Main` yang menjadi titik awal untuk menjalankan program.

- `controller`  
  Berisi kelas `IkanController` yang mengatur proses pengelolaan data dan menghubungkan input pengguna dengan operasi database.

- `view`  
  Berisi kelas `IkanView` yang menangani tampilan menu, menerima input pengguna, menampilkan data, dan memberikan pesan hasil operasi.

- `model`  
  Berisi kelas `Ikan`, `IkanLaut`, `IkanAirTawar`, `LokasiPenangkapan`, `HasilPenangkapan`, serta interface `DataPerikanan` yang merepresentasikan data dan objek dalam program.

- `dao`  
  Berisi kelas `IkanDAO`, `IkanLautDAO`, `IkanAirTawarDAO`, `LokasiPenangkapanDAO`, dan `HasilPenangkapanDAO` yang menangani operasi pengelolaan data pada database.

- `database`  
  Berisi kelas `Koneksi` yang digunakan untuk menghubungkan program Java dengan database MySQL melalui JDBC.

**[MASUKKAN SS 2.1: Struktur package dan kelas pada NetBeans di sini]**

## 3. Penjelasan Alur Program

Alur program dimulai dari kelas `Main` yang menjalankan `IkanController`. Controller kemudian menampilkan menu melalui kelas `IkanView`. Pengguna dapat memilih menu untuk mengelola data ikan, lokasi penangkapan, hasil penangkapan, atau keluar dari program.

**[MASUKKAN SS 3.1: Tampilan menu utama program di sini]**

Pada menu pengelolaan data ikan, pengguna dapat memilih operasi tambah, tampil, ubah, dan hapus data. Ketika pengguna memasukkan data, program melakukan validasi input sesuai ketentuan yang diterapkan. Setelah input dinyatakan valid, controller meneruskan proses ke DAO untuk mengakses database. Hasil operasi kemudian ditampilkan melalui view.

**[MASUKKAN SS 3.2: Tampilan menu pengelolaan data ikan di sini]**

Pada proses tambah data, pengguna memasukkan informasi ikan sesuai kolom yang diminta. Data yang telah memenuhi validasi kemudian diproses dan disimpan ke database.

**[MASUKKAN SS 3.3: Output proses tambah data ikan di sini]**

Pada proses tampil data, program mengambil data dari database dan menampilkannya kepada pengguna.

**[MASUKKAN SS 3.4: Output tampilan data ikan di sini]**

Pada proses ubah data, pengguna memasukkan ID ikan dan data baru yang ingin diperbarui. Program memproses perubahan tersebut dan menampilkan pesan hasil operasi.

**[MASUKKAN SS 3.5: Output proses ubah data ikan di sini]**

Pada proses hapus data, pengguna memasukkan ID ikan yang akan dihapus. Program memproses penghapusan dan menampilkan pesan hasil operasi.

**[MASUKKAN SS 3.6: Output proses hapus data ikan di sini]**

Selain data ikan, program juga menyediakan menu pengelolaan lokasi penangkapan. Pengguna dapat menambahkan lokasi penangkapan dan menampilkan data lokasi yang tersimpan di database.

**[MASUKKAN SS 3.7: Output menu dan proses pengelolaan lokasi penangkapan di sini]**

Program juga menyediakan menu pengelolaan hasil penangkapan. Pengguna dapat menambahkan informasi hasil penangkapan dan menampilkan data yang telah tersimpan.

**[MASUKKAN SS 3.8: Output menu dan proses pengelolaan hasil penangkapan di sini]**

## 4. Penjelasan Penerapan Encapsulation dan Inheritance

### 4.1 Encapsulation

Encapsulation diterapkan dengan menggunakan access modifier `private` pada atribut kelas agar atribut tidak dapat diakses secara langsung dari luar kelas. Akses terhadap atribut dilakukan melalui method getter dan setter yang disediakan.

Contohnya terdapat pada kelas `Ikan`, yang memiliki atribut seperti `idIkan`, `namaIkan`, `jenisIkan`, dan `jumlahStok`. Dengan penerapan encapsulation, pengaksesan dan perubahan nilai atribut dapat dilakukan melalui method yang sesuai.

**[MASUKKAN SS 4.1: Kode kelas Ikan yang menunjukkan atribut private, getter, dan setter di sini]**

### 4.2 Inheritance

Inheritance diterapkan melalui kelas `IkanLaut` dan `IkanAirTawar` yang mewarisi atribut serta perilaku dari kelas induk `Ikan`. Kedua kelas tersebut memiliki atribut tambahan sesuai karakteristik masing-masing jenis ikan.

Kelas `IkanLaut` memiliki atribut `kedalamanHabitat`, sedangkan kelas `IkanAirTawar` memiliki atribut `jenisPerairan`. Dengan inheritance, kedua kelas dapat menggunakan kembali atribut dan perilaku umum yang tersedia pada kelas `Ikan`.

**[MASUKKAN SS 4.2: Kode kelas IkanLaut dan IkanAirTawar yang menunjukkan penggunaan extends Ikan di sini]**

## 5. Penjelasan Penerapan Polymorphism dan Abstraction

### 5.1 Polymorphism

Polymorphism diterapkan melalui method overriding pada kelas `IkanLaut` dan `IkanAirTawar`. Kedua kelas memiliki implementasi method `tampilkanDetail()` yang berbeda sesuai karakteristik objeknya.

Pada kelas `IkanLaut`, detail yang ditampilkan mencakup kedalaman habitat. Sementara itu, kelas `IkanAirTawar` menampilkan informasi jenis perairan. Dengan demikian, method yang sama dapat menghasilkan perilaku berbeda sesuai objek yang menjalankannya.

**[MASUKKAN SS 5.1: Kode method tampilkanDetail() pada kelas IkanLaut dan IkanAirTawar di sini]**

### 5.2 Abstraction

Abstraction diterapkan melalui kelas abstrak `Ikan` dan interface `DataPerikanan`. Kelas `Ikan` digunakan sebagai dasar bagi kelas turunannya, sedangkan interface `DataPerikanan` menetapkan method `tampilkanData()` yang harus diterapkan oleh kelas yang mengimplementasikannya.

Kelas `Ikan` juga mendefinisikan method abstrak `tampilkanDetail()` yang implementasinya diberikan oleh kelas turunannya. Penerapan abstraction membantu memisahkan perilaku umum dengan implementasi khusus setiap jenis ikan.

**[MASUKKAN SS 5.2: Kode interface DataPerikanan dan kelas abstrak Ikan di sini]**

## 6. Penjelasan Penerapan JDBC

JDBC (*Java Database Connectivity*) digunakan untuk menghubungkan program Java dengan database MySQL. Pada program ini, koneksi database diatur melalui kelas `Koneksi` yang menggunakan `DriverManager` untuk membuat koneksi ke database `perikanan_pbo_db`.

JDBC diterapkan pada kelas DAO yang mengakses database menggunakan objek seperti `Connection`, `PreparedStatement`, dan `ResultSet`. `PreparedStatement` digunakan untuk menjalankan perintah SQL dengan parameter, sedangkan `ResultSet` digunakan untuk membaca hasil query. Melalui JDBC, program dapat menjalankan operasi pengelolaan data sesuai fungsi masing-masing DAO.

**[MASUKKAN SS 6.1: Kode kelas Koneksi.java yang menunjukkan koneksi ke database MySQL di sini]**

**[MASUKKAN SS 6.2: Kode salah satu DAO yang menunjukkan query SQL dan penggunaan PreparedStatement di sini]**

**[MASUKKAN SS 6.3: Tampilan database MySQL yang menunjukkan tabel dan data program di sini]**
