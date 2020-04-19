# Standard Calculator
## Kelompok 12
* 13518067 / Tifany Angelia
* 13518106 / Thoriq Akbar Mahmudi
* 13518109 / Andjani Kiranadewi
* 13518130 / Ryan Daniel
* 13518136 / Reyvan Rizky Irsandy


Asisten: Putu Gery Wahyu Nugraha

## Struktur kode
Relatif dari folder repository, semua source code terdapat dalam folder `if2210-avatar-duel-project-template-master/src`. Di dalam folder `src`, terdapat 2 folder: `main` dan `test`. 

* Folder `src` terdiri dari 2 sub-folder: `java` dan `resources`.
  * Folder `java` yang menyimpan file .java yang terdiri baik struktur kelas maupun controller.
  * Folder `resources` yang menyimpan file .csv untuk menyimpan data kartu, image, dan .fxml untuk GUI.
* Folder `test` mengandung kelas-kelas testing program untuk menguji fungsi *phase*, *player*, *card*, *field*, *deck*, dan *hand*.

## Cara compile dan run
### Linux
1. cd ke path folder src. Dari folder git repository:
   ```sh
   cd if2210-avatar-duel-project-template-master
   ```
2. Panggil command chmod:
   ```sh
   chmod +x gradlew
   ```
3. Jalankan program:
   ```sh
   ./gradlew run
   ```
### Windows
1. cd ke path folder src. Dari folder git repository:
   ```sh
   cd if2210-avatar-duel-project-template-master
   ```
2. Jalankan program:
   ```sh
   gradlew run
   ```

## Screenshot
![Avatar Duel!](./NewGame.png?raw=true "New Game")
![Avatar Duel!](./EndGame.png?raw=true "End Game")
