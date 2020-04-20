# Avatar Duel!
## OOP Kelompok 10
* 13518067/ Tifany Angelia
* 13518106/ Thoriq Akbar Mahmudi
* 13518109/ Andjani Kiranadewi
* 13518130/ Ryan Daniel
* 13518136/ Reyvan Rizky Irsandy

Asisten: Putu Gery Wahyu Nugraha/ 13516100

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
1. Memulai pada Draw Phase.
![Avatar Duel!](./NewGame.png?raw=true "New Game")
2. Melakukan summon pada Main Phase.
![Avatar Duel!](./Summon.png?raw=true "Summon")
3. Melakukan sinkronisasi antara SkillCard dan CharacterCard pada field
![Avatar Duel!](./Sync.png?raw=true "Sync")
4. Melakukan attack pada Battle Phase.
![Avatar Duel!](./Attack.png?raw=true "Attack")
5. End Phase dan melakukan pergantian turn.
![Avatar Duel!](./ChangeTurn.png?raw=true "Change Turn")
6. Game berakhir karena nyawa salah satu pemain 0.
![Avatar Duel!](./EndGame.png?raw=true "End Game")
