CREATE DATABASE IF NOT EXISTS HotelManagement;
USE HotelManagement;
 
-- Create chucvu (Position/Role) table
CREATE TABLE CHUCVU (
    ID_CHUCVU NVARCHAR(20) PRIMARY KEY,
    TEN_CHUCVU NVARCHAR(20) CHECK (TEN_CHUCVU IN (N'quản lý', N'nhân viên'))
);


-- Create nhanvien (Employee) table
CREATE TABLE NHANVIEN (
    ID_NV NVARCHAR(20) PRIMARY KEY,
    TEN_NV NVARCHAR(100),
    EMAIL NVARCHAR(100),
    SDT_NV NVARCHAR(10),
    CCCD_NV NVARCHAR(12),
    GIOITINH NVARCHAR(5) CHECK (GIOITINH IN (N'nam', N'nữ')),
    ID_CHUCVU NVARCHAR(20),
    TRANGTHAI_NV NVARCHAR(20) CHECK (TRANGTHAI_NV IN (N'hoạt động', N'ngừng hoạt động')),
    FOREIGN KEY (ID_CHUCVU) REFERENCES CHUCVU(ID_CHUCVU)
);

-- Create khachhang (Customer) table
CREATE TABLE KHACHHANG (
    ID_KH NVARCHAR(20) PRIMARY KEY,
    TEN_KH NVARCHAR(100),
    GIOITINH NVARCHAR(5) CHECK (GIOITINH IN (N'nam', N'nữ')),
    SDT_KH NVARCHAR(10),
    EMAIL_KH NVARCHAR(200),
    CCCD_KH NVARCHAR(12),
    TRANGTHAI_KH NVARCHAR(20) CHECK (TRANGTHAI_KH IN (N'hoạt động', N'ngừng hoạt động'))
);

-- Create loaiphong (Room Type) table
CREATE TABLE LOAIPHONG (
    ID_LOAIPHG NVARCHAR(20) PRIMARY KEY,
    TEN_LOAIPHG NVARCHAR(100),
    DONGIA_PHG FLOAT,
    MOTA_PHG NVARCHAR(300),
    TRANGTHAI_LOAIPHG NVARCHAR(20) CHECK (TRANGTHAI_LOAIPHG IN (N'hoạt động', N'không hoạt động'))
);

-- Create phong (Room) table
CREATE TABLE PHONG (
    ID_PHG NVARCHAR(20) PRIMARY KEY,
    TEN_PHG NVARCHAR(100),
    ID_LOAIPHG NVARCHAR(20),
    TINHTRANG_PHG NVARCHAR(20) CHECK (TINHTRANG_PHG IN (N'trống', N'đã đặt', N'bảo trì', N'ngừng kinh doanh')),
    FOREIGN KEY (ID_LOAIPHG) REFERENCES LOAIPHONG(ID_LOAIPHG)
);

-- Create phieudatphong (Booking Form) table
CREATE TABLE PHIEUDATPHONG (
    ID_PHIEUDAT NVARCHAR(20) PRIMARY KEY,
    NGAYDAT DATE,
    NGATRA DATE,
    ID_NV NVARCHAR(20),
    ID_KH NVARCHAR(20),
    FOREIGN KEY (ID_NV) REFERENCES NHANVIEN(ID_NV),
    FOREIGN KEY (ID_KH) REFERENCES KHACHHANG(ID_KH)
);

-- Create chitietphieudat (Booking Details) table
CREATE TABLE CHITIETPHIEUDAT (
    ID_PHIEUDAT NVARCHAR(20),
    ID_PHG NVARCHAR(20),
    TEN_PHG NVARCHAR(100),
    TONGTIEN_CTPHIEUDAT FLOAT,
    TRANGTHAI NVARCHAR(20) CHECK (TRANGTHAI IN (N'chưa checkout', N'đã checkout')),
    PRIMARY KEY (ID_PHIEUDAT, ID_PHG),
    FOREIGN KEY (ID_PHIEUDAT) REFERENCES PHIEUDATPHONG(ID_PHIEUDAT),
    FOREIGN KEY (ID_PHG) REFERENCES PHONG(ID_PHG)
);

-- Create dichvu (Service) table
CREATE TABLE DICHVU (
    ID_DV NVARCHAR(20) PRIMARY KEY,
    TEN_DV NVARCHAR(100),
    DONGIA_DV FLOAT,
    MOTA_DV NVARCHAR(300)
);

-- Create chitietdichvu (Service Details) table
CREATE TABLE CHITIETDICHVU (
    ID_DV NVARCHAR(20),
    ID_PHIEUDAT NVARCHAR(10),
    SOLUONG_DV INT,
    TONGTIEN_DV FLOAT,
    PRIMARY KEY (ID_DV, ID_PHIEUDAT),
    FOREIGN KEY (ID_DV) REFERENCES DICHVU(ID_DV),
    FOREIGN KEY (ID_PHIEUDAT) REFERENCES PHIEUDATPHONG(ID_PHIEUDAT)
);

-- Create taikhoan (Account) table - links to both employees and customers
CREATE TABLE TAIKHOAN (
    ID_TK NVARCHAR(20) PRIMARY KEY,
    USERNAME NVARCHAR(100),
    PASSWORD NVARCHAR(30),
    ID_NV NVARCHAR(20),
    ID_KH NVARCHAR(20),
    FOREIGN KEY (ID_NV) REFERENCES NHANVIEN(ID_NV),
    FOREIGN KEY (ID_KH) REFERENCES KHACHHANG(ID_KH),
    CHECK (
        (ID_NV IS NOT NULL AND ID_KH IS NULL) OR 
        (ID_NV IS NULL AND ID_KH IS NOT NULL)
    )
);

-- Create hoadon (Invoice) table
CREATE TABLE HOADON (
    ID_HD NVARCHAR(20) PRIMARY KEY,
    TONGTIEN_HD FLOAT,
    NGAYLAP_HD DATE,
    ID_PHIEUDAT NVARCHAR(20),
    FOREIGN KEY (ID_PHIEUDAT) REFERENCES PHIEUDATPHONG(ID_PHIEUDAT)
);
 
 -- Insert data into CHUCVU (Position/Role) table
INSERT INTO CHUCVU (ID_CHUCVU, TEN_CHUCVU) VALUES
(N'CV_QL', N'quản lý'),
(N'CV_NV', N'nhân viên');

-- Insert data into NHANVIEN (Employee) table
INSERT INTO NHANVIEN (ID_NV, TEN_NV, EMAIL, SDT_NV, CCCD_NV, GIOITINH, ID_CHUCVU, TRANGTHAI_NV) VALUES
(N'NV_01', N'Nguyễn Văn An', N'an.nguyen@hotel.com', N'0901234567', N'079123456789', N'nam',N'CV_QL' , N'hoạt động'),
(N'NV_02', N'Trần Thị Bình', N'binh.tran@hotel.com', N'0912345678', N'079234567890', N'nữ', N'CV_NV', N'hoạt động'),
(N'NV_03', N'Lê Văn Cường', N'cuong.le@hotel.com', N'0923456789', N'079345678901', N'nam',N'CV_QL', N'hoạt động'),
(N'NV_04', N'Phạm Thị Dung', N'dung.pham@hotel.com', N'0934567890', N'079456789012', N'nữ', N'CV_NV', N'hoạt động'),
(N'NV_05', N'Hoàng Văn Em', N'em.hoang@hotel.com', N'0945678901', N'079567890123', N'nam',N'CV_QL', N'hoạt động'),
(N'NV_06', N'Ngô Thị Giang', N'giang.ngo@hotel.com', N'0956789012', N'079678901234', N'nữ',N'CV_NV', N'hoạt động'),
(N'NV_07', N'Đinh Văn Huy', N'huy.dinh@hotel.com', N'0967890123', N'079789012345', N'nam',N'CV_NV', N'hoạt động'),
(N'NV_08', N'Bùi Thị Lan', N'lan.bui@hotel.com', N'0978901234', N'079890123456', N'nữ',N'CV_NV', N'ngừng hoạt động'),
(N'NV_09', N'Đỗ Văn Minh', N'minh.do@hotel.com', N'0989012345', N'079901234567', N'nam',N'CV_NV', N'hoạt động'),
(N'NV_10', N'Vũ Thị Ngọc', N'ngoc.vu@hotel.com', N'0990123456', N'079012345678', N'nữ',N'CV_NV', N'hoạt động');

-- Insert data into KHACHHANG (Customer) table
INSERT INTO KHACHHANG (ID_KH, TEN_KH, GIOITINH, SDT_KH, EMAIL_KH, CCCD_KH, TRANGTHAI_KH) VALUES
(N'KH_01', N'Trần Văn Phúc', N'nam', N'0801234567', N'phuc.tran@gmail.com', N'080123456789', N'hoạt động'),
(N'KH_02', N'Nguyễn Thị Quỳnh', N'nữ', N'0812345678', N'quynh.nguyen@gmail.com', N'080234567890', N'hoạt động'),
(N'KH_03', N'Lê Văn Sơn', N'nam', N'0823456789', N'son.le@gmail.com', N'080345678901', N'hoạt động'),
(N'KH_04', N'Phạm Thị Thảo', N'nữ', N'0834567890', N'thao.pham@gmail.com', N'080456789012', N'hoạt động'),
(N'KH_05', N'Hoàng Văn Uy', N'nam', N'0845678901', N'uy.hoang@gmail.com', N'080567890123', N'hoạt động'),
(N'KH_06', N'Ngô Thị Vân', N'nữ', N'0856789012', N'van.ngo@gmail.com', N'080678901234', N'hoạt động'),
(N'KH_07', N'Đinh Văn Xuân', N'nam', N'0867890123', N'xuan.dinh@gmail.com', N'080789012345', N'ngừng hoạt động'),
(N'KH_08', N'Bùi Thị Yến', N'nữ', N'0878901234', N'yen.bui@gmail.com', N'080890123456', N'hoạt động'),
(N'KH_09', N'Đỗ Văn Zung', N'nam', N'0889012345', N'zung.do@gmail.com', N'080901234567', N'hoạt động'),
(N'KH_10', N'Vũ Thị Ánh', N'nữ', N'0890123456', N'anh.vu@gmail.com', N'080012345678', N'hoạt động');

-- Insert data into LOAIPHONG (Room Type) table
INSERT INTO LOAIPHONG (ID_LOAIPHG, TEN_LOAIPHG, DONGIA_PHG, MOTA_PHG, TRANGTHAI_LOAIPHG) VALUES
(N'LP_01', N'Phòng Đơn', 500000, N'Phòng 1 giường đơn, có ban công, view thành phố', N'hoạt động'),
(N'LP_02', N'Phòng Đôi', 800000, N'Phòng 1 giường đôi, có ban công, view thành phố', N'hoạt động'),
(N'LP_03', N'Phòng Gia Đình', 1200000, N'Phòng 2 giường đôi, phòng khách riêng, view biển', N'hoạt động'),
(N'LP_04', N'Phòng Suite', 2000000, N'Phòng hạng sang với phòng khách và phòng ngủ riêng biệt', N'hoạt động'),
(N'LP_05', N'Phòng VIP', 3000000, N'Phòng cao cấp nhất với dịch vụ đặc biệt và view toàn cảnh', N'hoạt động'),
(N'LP_06', N'Phòng Đơn Tiêu Chuẩn', 450000, N'Phòng 1 giường đơn, tiện nghi cơ bản', N'hoạt động'),
(N'LP_07', N'Phòng Đôi Tiêu Chuẩn', 750000, N'Phòng 1 giường đôi, tiện nghi cơ bản', N'hoạt động'),
(N'LP_08', N'Phòng Đơn Hướng Biển', 600000, N'Phòng 1 giường đơn, view biển', N'không hoạt động'),
(N'LP_09', N'Phòng Đôi Hướng Biển', 900000, N'Phòng 1 giường đôi, view biển', N'hoạt động'),
(N'LP_10', N'Phòng Connecting', 1500000, N'2 phòng thông nhau dành cho gia đình hoặc nhóm bạn', N'hoạt động');

-- Insert data into PHONG (Room) table
INSERT INTO PHONG (ID_PHG, TEN_PHG, ID_LOAIPHG, TINHTRANG_PHG) VALUES
(N'P_101', N'Phòng 101', N'LP_01', N'trống'),
(N'P_102', N'Phòng 102', N'LP_01', N'đã đặt'),
(N'P_201', N'Phòng 201', N'LP_02', N'trống'),
(N'P_202', N'Phòng 202', N'LP_02', N'đã đặt'),
(N'P_301', N'Phòng 301', N'LP_03', N'trống'),
(N'P_302', N'Phòng 302', N'LP_03', N'bảo trì'),
(N'P_401', N'Phòng 401', N'LP_04', N'trống'),
(N'P_402', N'Phòng 402', N'LP_04', N'đã đặt'),
(N'P_501', N'Phòng 501', N'LP_05', N'trống'),
(N'P_502', N'Phòng 502', N'LP_05', N'ngừng kinh doanh');

-- Insert data into PHIEUDATPHONG (Booking Form) table
INSERT INTO PHIEUDATPHONG (ID_PHIEUDAT, NGAYDAT, NGATRA, ID_NV, ID_KH) VALUES
(N'PDP_1', '2025-03-10', '2025-03-12', N'NV_02', 1),
(N'PDP_2', '2025-03-12', '2025-03-15', N'NV_04', 2),
(N'PDP_3', '2025-03-14', '2025-03-16', N'NV_06', 3),
(N'PDP_4', '2025-03-15', '2025-03-18', N'NV_07', 4),
(N'PDP_5', '2025-03-16', '2025-03-20', N'NV_09', 5),
(N'PDP_6', '2025-03-17', '2025-03-19', N'NV_02', 6),
(N'PDP_7', '2025-03-18', '2025-03-22', N'NV_04', 8),
(N'PDP_8', '2025-03-19', '2025-03-21', N'NV_06', 9),
(N'PDP_9', '2025-03-20', '2025-03-25', N'NV_07', 10),
(N'PDP_10', '2025-03-22', '2025-03-24', N'NV_09', 1);

-- Insert data into CHITIETPHIEUDAT (Booking Details) table
INSERT INTO CHITIETPHIEUDAT (ID_PHIEUDAT, ID_PHG, TEN_PHG, TONGTIEN_CTPHIEUDAT, TRANGTHAI) VALUES
(N'PDP_1', N'P_102', N'Phòng 102', 1000000, N'đã checkout'),
(N'PDP_2', N'P_202', N'Phòng 202', 2400000, N'đã checkout'),
(N'PDP_3', N'P_401', N'Phòng 401', 4000000, N'chưa checkout'),
(N'PDP_4', N'P_301', N'Phòng 301', 3600000, N'chưa checkout'),
(N'PDP_5', N'P_402', N'Phòng 402', 8000000, N'chưa checkout'),
(N'PDP_6', N'P_201', N'Phòng 201', 1600000, N'đã checkout'),
(N'PDP_7', N'P_102', N'Phòng 102', 2000000, N'chưa checkout'),
(N'PDP_8', N'P_202', N'Phòng 202', 1600000, N'chưa checkout'),
(N'PDP_9', N'P_501', N'Phòng 501', 15000000, N'chưa checkout'),
(N'PDP_10', N'P_101', N'Phòng 101', 1000000, N'chưa checkout');

-- Insert data into DICHVU (Service) table
INSERT INTO DICHVU (ID_DV, TEN_DV, DONGIA_DV, MOTA_DV) VALUES
(N'DV_1', N'Dịch vụ giặt ủi', 200000, N'Giặt ủi quần áo trong ngày'),
(N'DV_2', N'Spa', 500000, N'Dịch vụ massage và chăm sóc da'),
(N'DV_3', N'Đưa đón sân bay', 300000, N'Dịch vụ xe đưa đón sân bay'),
(N'DV_4', N'Ăn sáng buffet', 250000, N'Bữa sáng buffet tại nhà hàng khách sạn'),
(N'DV_5', N'Hồ bơi', 100000, N'Sử dụng hồ bơi không giới hạn thời gian'),
(N'DV_6', N'Phòng gym', 150000, N'Sử dụng phòng tập thể dục không giới hạn thời gian'),
(N'DV_7', N'Dịch vụ phòng', 50000, N'Phục vụ đồ ăn tại phòng'),
(N'DV_8', N'Tour du lịch', 800000, N'Tour tham quan thành phố nửa ngày'),
(N'DV_9', N'Thuê xe máy', 200000, N'Thuê xe máy 1 ngày'),
(N'DV_10', N'Thuê xe đạp', 100000, N'Thuê xe đạp 1 ngày');


-- Insert data into CHITIETDICHVU (Service Details) table
INSERT INTO CHITIETDICHVU (ID_DV, ID_PHIEUDAT, SOLUONG_DV, TONGTIEN_DV) VALUES
(N'DV_1', N'PDP_1', 2, 400000),
(N'DV_2', N'PDP_1', 1, 500000),
(N'DV_3', N'PDP_2', 1, 300000),
(N'DV_4', N'PDP_3', 2, 500000),
(N'DV_5', N'PDP_4', 3, 300000),
(N'DV_6', N'PDP_5', 2, 300000),
(N'DV_7', N'PDP_6', 4, 200000),
(N'DV_8', N'PDP_7', 1, 800000),
(N'DV_9', N'PDP_8', 2, 400000),
(N'DV_10', N'PDP_9', 3, 300000);

-- Insert data into TAIKHOAN (Account) table
-- For employees (using ID_NV as USERNAME)
INSERT INTO TAIKHOAN (ID_TK, USERNAME, PASSWORD, ID_NV, ID_KH) VALUES
(N'TK_1', N'NV_01', N'pass123', N'NV_01', NULL),
(N'TK_2', N'NV_02', N'pass123', N'NV_02', NULL),
(N'TK_3', N'NV_03', N'pass123', N'NV_03', NULL),
(N'TK_4', N'NV_04', N'pass123', N'NV_04', NULL),
(N'TK_5', N'NV_05', N'pass123', N'NV_05', NULL),
(N'TK_6', N'NV_06', N'pass123', N'NV_06', NULL),
(N'TK_7', N'NV_07', N'pass123', N'NV_07', NULl),
(N'TK_8', N'NV_08', N'pass123', N'NV_08', NULl),
(N'TK_9', N'NV_09', N'pass123', N'NV_09', NULl),
(N'TK_10', N'NV_10', N'pass123', N'NV_10', NULl),
-- For customers (using SDT_KH as USERNAME)

(N'TK_11', N'0801234567', N'pass123', NULL, N'KH_01'),
(N'TK_12', N'0812345678', N'pass123', NULL, N'KH_02'),
(N'TK_13', N'0823456789', N'pass123', NULL, N'KH_03'),
(N'TK_14', N'0834567890', N'pass123', NULL, N'KH_04'),
(N'TK_15', N'0845678901', N'pass123', NULL, N'KH_05');

-- Insert data into HOADON (Invoice) table
INSERT INTO HOADON (ID_HD, TONGTIEN_HD, NGAYLAP_HD, ID_PHIEUDAT) VALUES
(N'HD_01', 1900000, '2025-03-12', N'PDP_1'),
(N'HD_02', 2700000, '2025-03-15', N'PDP_2'),
(N'HD_03', 4500000, '2025-03-16', N'PDP_3'),
(N'HD_04', 3900000, '2025-03-18', N'PDP_4'),
(N'HD_05', 8300000, '2025-03-20', N'PDP_5'),
(N'HD_06', 1800000, '2025-03-19', N'PDP_6'),
(N'HD_07', 2800000, '2025-03-22', N'PDP_7'),
(N'HD_08', 2000000, '2025-03-21', N'PDP_8'),
(N'HD_09', 15300000, '2025-03-25', N'PDP_9'),
(N'HD_10', 1000000, '2025-03-24', N'PDP_10');

