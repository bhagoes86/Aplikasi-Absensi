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

INSERT INTO tb_asisten_role(id_asisten_role, role, npm)
VALUES ('2', 'ROLE_USER', '58412085');

INSERT INTO public.tb_absensi_asisten(id_absen_asisten, baris, hari, kelas_praktikum, mata_praktikum, nama_asisten, nama_asisten_tetap, npm_asisten, ruang_praktikum, sesi, tanggal_jaga)
VALUES ('1', 'A', 'senin', '4IA04', 'RPL', 'rizki', 'mufrizal', '58412085', 'E1', 1, '2016-02-14');
