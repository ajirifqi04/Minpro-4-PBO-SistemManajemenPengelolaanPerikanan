# Sistem Manajemen Pengelolaan Perikanan

Nama : Aji Rifqi Suryana

NIM : 2509116054

## 1. Deskripsi Program

Sistem Manajemen Pengelolaan Perikanan merupakan program berbasis Java yang dibuat untuk membantu proses pengelolaan data perikanan secara terstruktur. Program ini menggunakan database MySQL untuk menyimpan dan mengelola data sehingga informasi yang telah dimasukkan dapat ditampilkan kembali sesuai kebutuhan.

Program ini memiliki beberapa fitur utama, yaitu pengelolaan data ikan, data lokasi penangkapan, dan data hasil penangkapan. Pada data ikan, pengguna dapat menambahkan data baru, melihat data yang tersimpan, mengubah data, dan menghapus data. Pengelolaan lokasi penangkapan digunakan untuk menyimpan informasi lokasi dan wilayah penangkapan yang berkaitan dengan ikan. Sementara itu, data hasil penangkapan digunakan untuk mencatat informasi hasil penangkapan, seperti tanggal dan kondisi hasil tangkapan.

Program dikembangkan dengan menerapkan konsep Pemrograman Berorientasi Objek (PBO), seperti *encapsulation*, *inheritance*, *polymorphism*, dan *abstraction*. Selain itu, program menggunakan Java Database Connectivity (JDBC) untuk menghubungkan aplikasi dengan database MySQL.

## 2. Struktur Package

Struktur *package* digunakan untuk mengelompokkan kelas berdasarkan fungsi dan tanggung jawabnya. Pemisahan ini bertujuan agar kode program lebih terorganisasi, mudah dipahami, dan lebih mudah dikembangkan.

Struktur *package* dalam program terdiri dari:

- **main**: Berisi kelas `Main` yang menjadi titik awal program. Kelas ini digunakan untuk menjalankan program dan memulai proses pengelolaan data melalui kelas yang menangani fitur utama.

- **controller**: Berisi kelas yang mengatur jalannya proses program, menerima pilihan pengguna, dan menghubungkan proses pada tampilan dengan operasi pengolahan data.
  
- **view**: Berisi kelas yang menangani tampilan menu, menerima masukan pengguna, serta menampilkan informasi dan hasil proses yang dijalankan.
  
- **model**: Berisi kelas yang merepresentasikan objek atau data dalam sistem perikanan, seperti ikan, ikan laut, ikan air tawar, lokasi penangkapan, dan hasil penangkapan.
  
- **dao**: Berisi kelas *Data Access Object* (DAO) yang menangani proses akses database, seperti menambahkan, menampilkan, mengubah, dan menghapus data menggunakan JDBC.
  
- **database**: Berisi kelas `Koneksi` yang digunakan untuk menghubungkan program Java dengan database MySQL.

Setiap *package* memiliki tugas yang berbeda, tetapi saling berhubungan untuk menjalankan fungsi program. Kelas pada bagian tampilan menangani interaksi dengan pengguna, bagian pengendali mengatur proses yang dijalankan, kelas model merepresentasikan data, sedangkan DAO menangani operasi terhadap database.

<img width="433" height="622" alt="image" src="https://github.com/user-attachments/assets/c2b564b6-5fe8-4388-b515-519f0915a9b3" />

## 3. Alur Program

### 3.1 Menjalankan Program

Program dimulai dengan menjalankan kelas `Main`. Kelas ini menjadi titik awal eksekusi program dan memanggil proses utama yang dikelola oleh kelas pengendali. Selanjutnya, program menampilkan menu utama melalui kelas tampilan agar pengguna dapat memilih fitur yang ingin digunakan.

Menu utama menjadi bagian awal interaksi pengguna dengan program. Setiap pilihan menu memiliki fungsi yang berbeda, sehingga pengguna perlu memasukkan nomor pilihan sesuai dengan fitur yang ingin dijalankan. Pilihan tersebut kemudian diproses oleh program untuk menentukan menu atau operasi yang harus ditampilkan.

<img width="288" height="122" alt="image" src="https://github.com/user-attachments/assets/957516cf-cf53-4196-b3bd-525e114079fd" />

### 3.2 Menu Pengelolaan Data Ikan

Ketika pengguna memilih menu pengelolaan data ikan, program menampilkan submenu yang berisi pilihan untuk menambahkan data ikan, menampilkan data ikan, mengubah data ikan, dan menghapus data ikan. Submenu ini memudahkan pengguna memilih operasi yang ingin dilakukan tanpa harus menjalankan fitur satu per satu secara terpisah.

Setelah pengguna memasukkan nomor pilihan, program memproses pilihan tersebut dan menjalankan fungsi yang sesuai. Jika pengguna memilih operasi penambahan, program meminta data ikan yang akan disimpan. Jika memilih operasi menampilkan data, program mengambil data yang tersimpan di database. Sementara itu, pilihan mengubah dan menghapus data akan meminta identitas data yang ingin diproses.

<img width="288" height="256" alt="image" src="https://github.com/user-attachments/assets/1c298901-5a41-4c5e-b633-ff8c2fa6f370" />

### 3.3 Menambahkan Data Ikan

Pada tahap ini, pengguna memilih fitur tambah data ikan. Program kemudian meminta informasi ikan yang diperlukan, seperti ID ikan, nama ikan, jenis ikan, jumlah stok, dan informasi tambahan sesuai dengan kategori ikan yang dipilih.

Program membedakan ikan laut dan ikan air tawar. Data ikan laut memiliki informasi tambahan berupa kedalaman habitat, sedangkan data ikan air tawar memiliki informasi tambahan berupa jenis perairan. Informasi tambahan tersebut digunakan untuk membedakan karakteristik kedua kategori ikan.

Setelah seluruh masukan diterima, program memproses data melalui kelas yang menangani pengelolaan ikan. Data kemudian diteruskan ke bagian akses database untuk disimpan ke dalam tabel yang sesuai. Jika proses penyimpanan berhasil, program menampilkan informasi bahwa data ikan berhasil ditambahkan. Data yang telah disimpan selanjutnya dapat ditampilkan kembali melalui menu tampil data.

<img width="355" height="409" alt="image" src="https://github.com/user-attachments/assets/aa6f140f-0b1e-4483-9554-3b6eb8ba7f1b" />

### 3.4 Menampilkan Data Ikan

Fitur tampil data ikan digunakan untuk melihat data ikan yang telah tersimpan di database. Ketika pengguna memilih menu ini, program menjalankan proses pengambilan data melalui kelas DAO. DAO menjalankan perintah SQL untuk membaca data dari tabel yang berkaitan, kemudian hasilnya dikembalikan ke program untuk ditampilkan.

Informasi yang ditampilkan menyesuaikan data yang tersimpan, seperti ID ikan, nama ikan, jenis ikan, dan jumlah stok. Informasi tambahan pada ikan laut atau ikan air tawar juga dapat ditampilkan sesuai dengan data yang dikelola oleh program.

Fitur ini membantu pengguna memeriksa data yang sudah dimasukkan dan memastikan bahwa data tersebut tersimpan serta dapat diakses kembali.

<img width="290" height="639" alt="image" src="https://github.com/user-attachments/assets/9942acec-78d5-484e-afdb-125a9158e255" />

### 3.5 Mengubah Data Ikan

Fitur ubah data ikan digunakan untuk memperbarui informasi ikan yang telah tersimpan. Pengguna memilih menu ubah data, kemudian memasukkan ID ikan yang ingin diubah. Program menggunakan ID tersebut untuk menentukan data yang menjadi tujuan perubahan.

Setelah data yang dituju ditentukan, program meminta pengguna memasukkan informasi baru sesuai dengan atribut yang dikelola. Data yang dimasukkan kemudian diteruskan ke bagian pengolahan data dan DAO untuk menjalankan proses pembaruan pada database.

Apabila proses pembaruan berhasil, program menampilkan pesan bahwa data ikan berhasil diubah. Dengan fitur ini, pengguna dapat memperbarui informasi tanpa perlu menghapus data lama dan menambahkan data yang sama dari awal.

<img width="362" height="409" alt="image" src="https://github.com/user-attachments/assets/83470f92-4f77-45c0-8364-42696b97cf5d" />

### 3.6 Menghapus Data Ikan

Fitur hapus data ikan digunakan untuk menghapus data tertentu dari database. Pengguna memilih menu hapus data, kemudian memasukkan ID ikan yang ingin dihapus. Program memproses ID tersebut untuk menentukan data yang akan menjadi sasaran penghapusan.

Selanjutnya, permintaan penghapusan diteruskan ke bagian DAO yang menjalankan perintah SQL untuk menghapus data berdasarkan ID yang diberikan. Program kemudian menampilkan hasil proses penghapusan sesuai dengan hasil operasi database.

Fitur ini membantu pengguna mengelola data agar informasi ikan yang sudah tidak diperlukan dapat dihapus dari sistem. Pengguna perlu memastikan ID yang dimasukkan sesuai dengan data yang ingin dihapus.

<img width="488" height="326" alt="image" src="https://github.com/user-attachments/assets/b9c84f34-c825-45e8-afe2-adb360adbfbf" />

### 3.7 Menu Pengelolaan Lokasi Penangkapan

Selain data ikan, program menyediakan fitur pengelolaan lokasi penangkapan. Ketika pengguna memilih menu lokasi penangkapan dari menu utama, program menampilkan submenu yang berisi pilihan untuk menambahkan lokasi penangkapan dan menampilkan data lokasi yang telah tersimpan.

Fitur ini digunakan untuk mencatat informasi lokasi penangkapan yang berkaitan dengan data ikan. Informasi yang dikelola mencakup ID lokasi, ID ikan, nama lokasi, dan wilayah. Penggunaan ID ikan membantu menghubungkan data lokasi dengan ikan yang telah terdaftar di dalam sistem.

<img width="277" height="206" alt="image" src="https://github.com/user-attachments/assets/de398139-5956-41b7-9654-2660798b5f76" />

### 3.8 Menambahkan Data Lokasi Penangkapan

Ketika pengguna memilih fitur tambah lokasi, program meminta informasi yang diperlukan untuk mencatat lokasi penangkapan. Pengguna memasukkan ID lokasi, ID ikan yang berkaitan, nama lokasi, dan wilayah penangkapan.

Sebelum data disimpan, program memeriksa keterkaitan ID ikan dengan data ikan yang tersedia. Pemeriksaan ini diperlukan agar lokasi penangkapan tidak dikaitkan dengan ID ikan yang tidak terdaftar. Jika data memenuhi ketentuan program, informasi tersebut diteruskan ke DAO untuk disimpan ke database.

Setelah proses penyimpanan selesai, program menampilkan hasilnya kepada pengguna. Data lokasi yang berhasil disimpan kemudian dapat dilihat melalui fitur tampil data lokasi penangkapan.

<img width="416" height="269" alt="image" src="https://github.com/user-attachments/assets/5329e79c-5118-4358-a04c-fea0d2c0af20" />

### 3.9 Menampilkan Data Lokasi Penangkapan

Fitur tampil lokasi penangkapan digunakan untuk melihat informasi lokasi yang sudah tersimpan di database. Program mengambil data melalui DAO, kemudian menampilkan hasilnya agar pengguna dapat mengetahui lokasi dan wilayah penangkapan yang telah dicatat.

Informasi yang ditampilkan mencakup atribut lokasi penangkapan yang dikelola program. Dengan adanya fitur ini, pengguna dapat memeriksa kembali data lokasi dan keterkaitannya dengan ID ikan yang digunakan.

<img width="273" height="391" alt="image" src="https://github.com/user-attachments/assets/c723e35e-b774-4054-b886-cc392b1f008f" />

### 3.10 Menu Pengelolaan Hasil Penangkapan

Program juga menyediakan menu pengelolaan hasil penangkapan. Menu ini digunakan untuk mencatat informasi mengenai hasil penangkapan yang berkaitan dengan data ikan. Ketika pengguna memilih menu tersebut, program menampilkan pilihan operasi yang tersedia, seperti menambahkan data hasil penangkapan dan menampilkan data yang telah tersimpan.

Pengelolaan hasil penangkapan dilakukan secara terpisah dari pengelolaan data ikan dan lokasi. Pemisahan ini membantu menjaga setiap jenis data tetap terorganisasi sesuai dengan fungsinya.

<img width="280" height="214" alt="image" src="https://github.com/user-attachments/assets/9f70e227-1054-4550-ba6d-a9bb0d6ac23c" />

### 3.11 Menambahkan Data Hasil Penangkapan

Pada fitur tambah hasil penangkapan, pengguna diminta memasukkan informasi seperti ID hasil penangkapan, ID ikan, tanggal, dan kondisi hasil penangkapan. Data tersebut digunakan untuk mencatat hasil penangkapan yang berkaitan dengan ikan tertentu.

Program memeriksa keterkaitan ID ikan dengan data ikan yang tersedia sebelum menyimpan informasi hasil penangkapan. Jika data memenuhi ketentuan, informasi diteruskan ke DAO untuk disimpan ke database. Setelah proses selesai, program menampilkan pesan sesuai dengan hasil penyimpanan.

Pencatatan ini membantu pengguna menyimpan informasi hasil penangkapan secara terstruktur sehingga dapat dilihat kembali melalui fitur tampil data hasil penangkapan.

<img width="475" height="273" alt="image" src="https://github.com/user-attachments/assets/23b7ab96-5d10-42b9-a457-40b51595ff37" />

### 3.12 Menampilkan Data Hasil Penangkapan

Fitur tampil hasil penangkapan digunakan untuk melihat data hasil penangkapan yang telah tersimpan. Program mengambil data dari database melalui DAO dan menampilkan informasi yang berkaitan dengan setiap catatan hasil penangkapan.

Informasi yang ditampilkan mencakup ID hasil penangkapan, ID ikan, tanggal, dan kondisi hasil penangkapan sesuai dengan atribut yang digunakan program. Fitur ini memudahkan pengguna memeriksa catatan yang telah dibuat tanpa harus memasukkan ulang data.

<img width="250" height="305" alt="image" src="https://github.com/user-attachments/assets/47b2bfb2-37fe-441e-a026-3f813c6e39b5" />

### 3.13 Keluar dari Program

Menu keluar digunakan ketika pengguna telah selesai menggunakan program. Setelah pengguna memilih opsi keluar, program mengakhiri proses pengelolaan data dan menghentikan perulangan menu sesuai dengan mekanisme yang diterapkan pada program.

Dengan adanya pilihan ini, pengguna dapat mengakhiri program melalui menu yang tersedia tanpa harus menghentikannya secara paksa.

<img width="538" height="244" alt="image" src="https://github.com/user-attachments/assets/696a5a27-79c6-427b-8335-09a4d0f8afd4" />

## 4. Penerapan Encapsulation dan Inheritance

### 4.1 Encapsulation

*Encapsulation* merupakan konsep PBO yang digunakan untuk membatasi akses langsung terhadap atribut suatu kelas. Dalam program ini, atribut pada kelas model dibuat menggunakan akses modifier `private`, sehingga atribut tersebut tidak dapat diakses secara langsung dari luar kelas.

Akses terhadap data dilakukan melalui *method* yang disediakan oleh kelas, seperti *getter*, *setter*, atau *method* lain yang sesuai dengan kebutuhan program. Cara ini membantu menjaga agar data tidak diubah secara sembarangan dan memungkinkan kelas melakukan pemeriksaan sebelum nilai atribut digunakan atau diperbarui.

Sebagai contoh, data ikan memiliki atribut seperti ID ikan, nama ikan, jenis ikan, dan jumlah stok. Dengan menerapkan *encapsulation*, pengelolaan atribut tersebut dilakukan melalui mekanisme yang disediakan oleh kelas ikan, bukan dengan mengakses atribut secara langsung dari kelas lain.

<img width="654" height="143" alt="image" src="https://github.com/user-attachments/assets/30653ca2-9ed2-4d78-8740-1f486c6d790e" />

<img width="710" height="260" alt="image" src="https://github.com/user-attachments/assets/f1d28939-c51c-4e2c-94c0-3917661f5306" />

### 4.2 Inheritance

*Inheritance* merupakan konsep pewarisan yang memungkinkan suatu kelas memperoleh atribut atau perilaku dari kelas lain. Dalam program ini, kelas `Ikan` digunakan sebagai kelas induk, sedangkan kelas `IkanLaut` dan `IkanAirTawar` menjadi kelas turunan.

Kelas `Ikan` merepresentasikan atribut umum yang dimiliki ikan, seperti ID, nama, jenis, dan jumlah stok. Kelas `IkanLaut` mewarisi karakteristik umum tersebut dan memiliki atribut tambahan berupa kedalaman habitat. Sementara itu, kelas `IkanAirTawar` mewarisi atribut umum ikan dan memiliki atribut tambahan berupa jenis perairan.

Penerapan *inheritance* membuat atribut dan perilaku umum ikan dapat digunakan oleh kelas turunannya tanpa perlu dituliskan kembali seluruhnya. Selain itu, setiap kelas turunan tetap dapat memiliki karakteristik khusus yang membedakannya dari kelas ikan secara umum.

<img width="228" height="89" alt="image" src="https://github.com/user-attachments/assets/2f1a1a77-8e88-4eed-89fc-d506bfe81b79" />

<img width="656" height="163" alt="image" src="https://github.com/user-attachments/assets/4b1a5f9e-f274-4b12-83f8-cba664dbec4a" />

## 5. Penerapan Polymorphism dan Abstraction

### 5.1 Polymorphism

*Polymorphism* merupakan konsep PBO yang memungkinkan suatu *method* memiliki perilaku berbeda bergantung pada objek yang menjalankannya. Dalam program ini, konsep tersebut diterapkan melalui *method overriding* pada kelas ikan laut dan ikan air tawar.

Kelas `IkanLaut` dan `IkanAirTawar` memiliki implementasi `tampilkanDetail()` masing-masing. Walaupun nama *method* yang digunakan sama, informasi yang ditampilkan dapat berbeda karena setiap kelas memiliki atribut khusus. Pada ikan laut, informasi khusus berkaitan dengan kedalaman habitat, sedangkan pada ikan air tawar berkaitan dengan jenis perairan.

Dengan penerapan ini, program dapat memanggil *method* yang sama melalui objek ikan, tetapi hasilnya menyesuaikan jenis objek yang digunakan. Hal ini membuat pengelolaan perilaku objek lebih fleksibel.

<img width="822" height="236" alt="image" src="https://github.com/user-attachments/assets/f58a7026-b5de-4ab0-a523-4a5bafe522dd" />

<img width="838" height="231" alt="image" src="https://github.com/user-attachments/assets/f7a4be70-7d33-4931-b3d7-9bccf663fe06" />

### 5.2 Abstraction dan Interface

*Abstraction* merupakan konsep yang digunakan untuk menampilkan hal-hal penting dari suatu objek dan menyembunyikan detail implementasi yang tidak perlu diketahui oleh bagian program lain.

Dalam program ini, kelas `Ikan` dibuat sebagai kelas abstrak (*abstract class*). Kelas tersebut menjadi dasar bagi kelas ikan laut dan ikan air tawar, tetapi tidak digunakan untuk membuat objek secara langsung. Kelas `Ikan` mendefinisikan karakteristik umum ikan serta *method* abstrak `tampilkanDetail()` yang perlu diimplementasikan oleh kelas turunannya.

Selain itu, program menggunakan *interface* `DataPerikanan` sebagai kontrak yang menetapkan perilaku `tampilkanData()`. Kelas yang menerapkan *interface* tersebut harus menyediakan implementasi dari *method* yang ditentukan. Pada kelas `Ikan`, perilaku `tampilkanData()` dapat diarahkan ke `tampilkanDetail()` sehingga informasi yang ditampilkan mengikuti implementasi kelas turunannya.

Penerapan *abstraction* membantu memisahkan ketentuan perilaku umum dari detail implementasi masing-masing jenis ikan. Dengan demikian, struktur program lebih terorganisasi dan dapat dikembangkan sesuai kebutuhan.

<img width="334" height="24" alt="image" src="https://github.com/user-attachments/assets/32571e54-c057-48c7-bb4a-39efaad92d73" />

<img width="490" height="34" alt="image" src="https://github.com/user-attachments/assets/66bcb218-303a-4080-9129-d1e79a71e737" />

<img width="406" height="87" alt="image" src="https://github.com/user-attachments/assets/18b4e526-5814-4274-8837-5800e34d0745" />

<img width="649" height="29" alt="image" src="https://github.com/user-attachments/assets/1b1fd6e1-2f62-42b0-917f-41d85bd178fc" />

## 6. Penerapan JDBC

Java Database Connectivity (JDBC) digunakan untuk menghubungkan program Java dengan database MySQL. Pada program ini, JDBC menjadi penghubung antara proses pengelolaan data dalam aplikasi dan penyimpanan data di database `perikanan_pbo_db`.

Koneksi database diatur melalui kelas `Koneksi` yang berada pada *package* `database`. Kelas ini menggunakan `DriverManager` untuk membuat koneksi ke MySQL berdasarkan URL database, nama pengguna, dan kata sandi yang telah ditentukan. Setelah koneksi berhasil dibuat, kelas DAO dapat menggunakan koneksi tersebut untuk menjalankan perintah SQL.

Kelas DAO bertanggung jawab menjalankan operasi database sesuai kebutuhan program. Operasi yang dilakukan mencakup penambahan data menggunakan perintah `INSERT`, pembacaan data menggunakan `SELECT`, pembaruan data menggunakan `UPDATE`, dan penghapusan data menggunakan `DELETE`. Hasil operasi kemudian diteruskan kembali ke bagian program yang memerlukannya.

Sebagai contoh, ketika pengguna menambahkan data ikan, program menerima masukan melalui tampilan, memproses data tersebut, lalu meneruskannya ke DAO. DAO menyiapkan dan menjalankan perintah SQL melalui JDBC untuk menyimpan data ke tabel yang sesuai. Saat pengguna memilih fitur tampil data, DAO menjalankan perintah `SELECT` untuk mengambil data dari database, kemudian hasilnya ditampilkan kepada pengguna.

Dengan menggunakan JDBC, data yang dikelola tidak hanya berada selama program berjalan, tetapi juga dapat disimpan dalam database dan diakses kembali ketika dibutuhkan. Pemisahan operasi database ke dalam kelas DAO juga membantu menjaga agar kode untuk akses data tidak bercampur langsung dengan kode tampilan.

<img width="1047" height="231" alt="image" src="https://github.com/user-attachments/assets/6c1f2ec8-e72e-4bfd-9bd1-1080f437fd2f" />

<img width="776" height="492" alt="image" src="https://github.com/user-attachments/assets/cec5169b-e446-4199-8a74-11bd31f35351" />

<img width="829" height="659" alt="image" src="https://github.com/user-attachments/assets/91a84a18-44bc-4e15-a707-94c3a2c0d5ba" />
