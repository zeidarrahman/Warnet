Microsoft Windows [Version 10.0.18362.720]
(c) 2019 Microsoft Corporation. All rights reserved.

C:\Users\ZEIDAR>sqlplus system

SQL*Plus: Release 11.2.0.2.0 Production on Sat Apr 11 08:52:25 2020

Copyright (c) 1982, 2014, Oracle.  All rights reserved.

Enter password:

Connected to:
Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production

SQL> create tablespace zeidar_07030
  2  datafile 'D:\BASDAT\Modul 1\Tugas Praktikum\zeidar_07030.dbf'
  3  SIZE 30M;

Tablespace created.

SQL> create user zeidar_07030
  2  identified by 220100
  3  default tablespace zeidar_07030
  4  quota 30M on zeidar_07030;

User created.

SQL> grant all privileges to zeidar_07030;

Grant succeeded.

SQL> conn zeidar_07030/220100;
Connected.
SQL> create table Kasir_07030
    (
    Username VARCHAR2(6) not null,
    Password VARCHAR(6) not null,
    Nama_kasir VARCHAR2(15),
    Alamat VARCHAR2(100),
    No_telp NUMBER(12),
    constraint PK_Kasir primary key (Username)
    );

Table created.


SQL> create table Voucher_07030
    (
    Kode_voucher VARCHAR2(6) not null,
    Username VARCHAR2(6),
    Id_paket INTEGER,
    Nama_guest VARCHAR2(16),
    Tanggal DATE,
    Total_jam NUMBER(3),
    Harga NUMBER(9),
    constraint PK_Voucher primary key (Kode_voucher)
    );

Table created.

SQL> create table Paket_07030
  2  (
  3  Id_paket INTEGER not null,
  4  Nama_paket VARCHAR2(16),
  5  Jam_paket NUMBER(3),
  6  constraint PK_Paket primary key (Id_paket)
  7  );

Table created.

SQL> create table Komputer_07030
  2  (
  3  Id_komp INTEGER not null
  4  constraint PK_Komputer primary key (Id_komp)
  5  );

table created.

SQL> create table LogActivity_07030
  2  (
  3  Kode_Voucher VARCHAR2(16),
  4  Id_komp INTEGER,
  5  Tanggal_log DATE,
  6  Jam_login NUMBER(3),
  7  Jam_logout NUMBER(3)
  8  );

SQL> alter table LogActivity_07030
  2  add constraint FK_Kode_Voucher FOREIGN KEY (Kode_Voucher)
  3  references Voucher_07030(Kode_Voucher)
  4  add constraint FK_Id_Komp FOREIGN KEY (Id_komp)
  5  references Komputer_07030(Id_komp);

Table altered.

SQL> alter table Voucher_07030
  2  add constraint FK_Username FOREIGN KEY (Username)
  3  references Kasir_07030(Username)
  4  add constraint FK_Id_paket FOREIGN KEY (Id_paket)
  5  references Paket_07030(Id_paket);

Table altered.

SQL> create sequence Id_komp
  2  minvalue 1
  3  maxvalue 10
  4  start with 1
  5  increment by 1
  6  cache 20;

Sequence created.

SQL> alter table Voucher_07030 rename column Nama_pelanggan to Nama_guest_07030;

Table altered.

SQL> alter table Paket_07030
  2  add constraint Nama_paket UNIQUE (Nama_paket);

Table altered.

SQL>