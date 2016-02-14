/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 10:27:40 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/SQLTemplate.sql.
 * 
 */

INSERT INTO tb_asisten(npm, enable, kelas, nama, password)
VALUES 
('58412085', true, '4IA04', 'Rizki Mufrizal', '$2a$10$e3r6aos5Apwe21dtohD0pO/ikeqlM0KKzoBGY/KMr1z.vsJYLk/hC');

INSERT INTO tb_absensi_hari(id_absensi_hari, hari)
VALUES
('1', 'senin'),
('2', 'selasa'),
('3', 'rabu'),
('4', 'kamis'),
('5', 'jumat'),
('6', 'sabtu');

INSERT INTO public.tb_absensi_kehadiran(id_absen_kehadiran, baris, kelas_praktikum, mata_praktikum, nama_asisten, nama_asisten_tetap, npm_asisten, ruang_praktikum, sesi, id_absensi_hari)
VALUES ('1', 'A', 'RPL', 'rizki', 'mufrizal', '58412084', 'E1', '1', 1, '1');