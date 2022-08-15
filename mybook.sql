-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2022 at 05:36 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mybook`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `gia` int(11) NOT NULL,
  `iddonhang` int(11) NOT NULL,
  `nguoimua` int(11) NOT NULL,
  `sanpham` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `thoigian` datetime NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `gia`, `iddonhang`, `nguoimua`, `sanpham`, `soluong`, `thoigian`, `trangthai`) VALUES
(21, 20000, 19, 1, 16, 3, '2022-08-15 15:14:33', 0),
(22, 60000, 19, 1, 17, 4, '2022-08-15 15:14:33', 0),
(23, 20000, 20, 3, 68, 4, '2022-08-15 21:59:48', 0),
(24, 50000, 20, 3, 64, 4, '2022-08-15 21:59:48', 0);

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `idkhachhang` int(11) DEFAULT NULL,
  `thanhtien` int(11) DEFAULT NULL,
  `timedathang` datetime DEFAULT NULL,
  `trangthai` int(11) DEFAULT NULL,
  `timenhanhang` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `donhang`
--

INSERT INTO `donhang` (`id`, `idkhachhang`, `thanhtien`, `timedathang`, `trangthai`, `timenhanhang`) VALUES
(19, 1, 300000, '2022-08-15 15:14:33', 0, NULL),
(20, 3, 280000, '2022-08-15 21:59:48', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `phanhoi`
--

CREATE TABLE `phanhoi` (
  `id` int(11) NOT NULL,
  `idkhachhang` int(11) NOT NULL,
  `noidung` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `tenkhachhang` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `phanhoi`
--

INSERT INTO `phanhoi` (`id`, `idkhachhang`, `noidung`, `tenkhachhang`, `time`) VALUES
(1, 1, 'Sách hay vai noi shop ạ', 'Nguyễn Văn Hân', '2022-08-15 14:40:56'),
(2, 3, 'Sách tốt vê lù, cảm ơn shop nhé', 'Phạm Ngọc Kiên', '2022-08-15 22:00:28');

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `id` int(11) NOT NULL,
  `anh` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `gia` int(11) NOT NULL,
  `nguoidang` int(11) NOT NULL,
  `noidung` varchar(1000) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `nxb` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `soluong` int(11) NOT NULL,
  `tacgia` int(11) NOT NULL,
  `tensach` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `theloai` int(11) NOT NULL,
  `thoigiandang` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`id`, `anh`, `gia`, `nguoidang`, `noidung`, `nxb`, `soluong`, `tacgia`, `tensach`, `theloai`, `thoigiandang`) VALUES
(1, 'doithua.jfif', 20000, 1, 'Đời thừa - ấn bản mới phát hành 2016 của Minh Long Book tuyển chọn những truyện ngắn đặc sắc của Nam Cao xoay quanh cuộc sống người trí thức, với những tuyên ngôn để đời của nhà văn Nam Cao về văn chương, nghệ thuật', 'Kim Đồng', 30, 3, 'Đời thừa', 5, '2022-08-15 13:44:40'),
(2, 'lao_hac.jpg', 10000, 1, 'Lão Hạc là một truyện ngắn của nhà văn Nam Cao được viết năm 1943. Tác phẩm được đánh giá là một trong những truyện ngắn tiêu biểu của dòng văn học hiện thực', 'Kim Đồng', 40, 3, 'Lão Hạc', 5, '2022-08-15 13:46:20'),
(3, 'ythien.jfif', 40000, 1, 'Ỷ Thiên Đồ Long ký, còn gọi là Cô gái Đồ Long, là một tiểu thuyết võ hiệp của nhà văn Kim Dung. Đây là cuốn cuối cùng trong bộ tiểu thuyết Xạ điêu tam bộ khúc. Ỷ Thiên Đồ Long ký được Hương Cảng Thương báo xuất bản lần đầu năm 1961 tại Hồng Kông.', 'Kim Đồng', 100, 2, 'Ỷ THIÊN ĐỒ LONG KÝ', 2, '2022-08-15 13:48:04'),
(4, 'truyen-dau-pha-thuong-khung.jpg', 50000, 1, '- Đấu Phá Thương Khung là một câu chuyện huyền huyễn đặc sắc kể về Tiêu Viêm, một thiên chi kiêu tử với thiên phú tu luyện mà ai ai cũng hâm mộ, bỗng một ngày người mẹ mất đi đễ lại di vật là một chiếc giới chỉ màu đen nhưng từ khi đó Tiêu Viêm đã mất đi thiên phú tu luyện của mình.\r\n\r\n- Từ thiên tài rớt xuống làm phế vật trong 3 năm, rồi bị vị hôn thê thẳng thừng từ hôn, làm dấy lên ý chí nam nhi của mình, Tiêu Viêm nhờ di vật của mẫu thân để lại là 1 chiếc hắc giới chỉ (nhẫn màu đen)Tiêu Viêm gặp được hồn của Dược Lão (Dược Trần – Dược tôn giả) 1 đại luyện dược tông sư của đấu khí đại lục…\r\n\r\n- Từ đó cuộc đời của Tiêu Viêm có những biến hóa gì? Gặp được các đại ngộ gì? Thân phận thật sự của Huân Nhi (thanh mai trúc mã lúc nhỏ của Tiêu Viêm) ra sao? Bí mật của gia tộc hắn là gì? Cùng theo dõi bộ truyện Đấu Phá Thương Khung để có thể giải đáp các thắc mắc này các bạn nhé!', 'Internet', 200, 10, 'Đấu Phá Thương Khung', 1, '2022-08-15 13:51:35'),
(5, 'dau-la-dai-luc-230420.jpg', 70000, 1, 'Một đại lục không hề yên bình, một cuộc sống đầy hiểm nguy, phiêu lưu nhưng cũng không kém phần lãng mạn. tình yêu, thù hận, trách nhiệm… Tiếp bước những tiền bối đi trước, Hoắc Vũ Hạo và đời sau sử lai khắc thất quái, bằng niềm tin nhiệt huyết tuổi trẻ đã gây dựng lại đường môn tái lập những huy hoàng xưa kia của các tiền bối đi trước…\r\n\r\nKiếp trước là thiên tài sau khi chế tạo ám khí cao nhất của đường môn: Phật Nộ Liên Hoa. Xuyên việt mang theo võ công cùng với ám khí Đường Môn đến thế giới không có võ công cùng ám khí siêu đẳng như thế, chuyện gì sẽ xảy ra tiếp theo? Hãy cùng nhau theo dõi Đấu La Đại Lục để biết rõ bạn nhé.', 'Internet', 200, 8, 'Đấu La Đại Lục', 1, '2022-08-15 13:53:35'),
(6, 'tuu-than-am-duong-mien.jpg', 30000, 1, 'Sau khi hoàn thành siêu phẩm Đấu La Đại Lục thì Đường Gia Tam Thiếu đã bắt tay ngay vào bộ truyện mới có tên Âm Dương Miện. Trong hơn 6 năm cầm bút của mình, có lẽ đây là tác phẩm mà Đ3 đã dành nhiều tâm sức nhất. Để chuẩn bị cho Âm Dương Miện thì trong suốt thời gian viết Đấu La, tác giả đã đi rất nhiều nơi để thu thập các loại tài liệu, lấy âm dương, ngũ hành, thiên can và ma huyễn cùng kết hợp lại để tạo nên một tân thế giới kỳ huyễn thú vị và tràn ngập sự sáng tạo với một chức nghiệp mới: Phẩm Tửu Sư', 'Internet', 150, 8, 'TỬU THẦN (ÂM DƯƠNG MIỆN)', 1, '2022-08-15 13:55:16'),
(7, 'sinh-tieu-thu-ho-than.jpg', 40000, 1, 'Truyện kể về năm 2xxx, có một lưu manh tên là Tề Nhạc do \"bị đá\" mà đánh người gần chết. Vì sợ tội nên chạy lên Tây Tạng. Ai ngờ được một vị \"tiểu tăng\" bảo hắn là một trong 13 Sinh Tiếu Thủ Hộ Thần .\r\n\r\nSinh Tiếu Thủ Hộ Thần gồm: Kỳ Lân (đứng đầu trong Sinh Tiếu Thủ Hộ Thần) và 12 con giáp: Tử Thử, Sửu Ngưu, Dần Hổ, Mão Thỏ, Thần Long, Tị Xà, Ngọ Mã, Vị Dương, Thân Hầu, Dậu Kê, Tuất Cẩu và Hợi Trư.\r\n\r\nSau khi thức tỉnh năng lực của mình, Tề Nhạc bắt đầu tu luyện và tìm kiếm 12 Sinh Tiếu Thủ Hộ Thần còn lại, chống lại những thế lực muốn xâm lấn phương đông....', 'Internet', 134, 8, 'SINH TIẾU THỦ HỘ THẦN', 1, '2022-08-15 13:58:04'),
(8, 'than-an-vuong-toa.jpg', 35000, 1, 'Vào thời khắc mà Ma Tộc cường thế và nhân loại đang bên bờ của sự diệt vong thì Lục Đại Thánh Điện quật khởi mang theo hi vọng dẫn dắt nhân loại bảo vệ mảnh lãnh thổ cuối cùng.\r\n\r\n- Một thiếu niên vì cứu mẫu thân của mình mà gia nhập Kỵ Sĩ Thánh Điện, kỳ tích, quỷ kế không ngừng xoay quanh hắn. Trong con đường để giải cứu nhân loại và tìm đến đỉnh cao của sự tu luyện hắn đã đi tìm và giải đáp rất nhiều bí ẩn của đại lục.\r\n\r\n- Tại cái thế giới hỗn loạn mà nhân loại Lục Đại Thánh Điện cùng Ma Tộc Thất Thập Nhị Trụ Ma Thần đấu đá lẫn nhau này, hắn có thể đi lên vương tọa tượng trưng cho sự vinh quang cao nhất của kỵ sĩ hay không? Và liệu đỉnh cao của sự tu luyện có hay không chỉ dừng ở đại lục này hay còn vị diện khác cao cấp hơn.', 'Internet', 200, 8, 'THẦN ẤN VƯƠNG TỌA', 1, '2022-08-15 13:59:45'),
(9, 'nguyen-ton.jpg', 50000, 1, 'Dùng huyền hoàng khí bạn thân sở hữu, mọi thứ thiện địa nhật nguyệt tinh đều bị ta nuốt hết.', 'Internet', 300, 10, 'NGUYÊN TÔN', 1, '2022-08-15 14:00:58'),
(10, 'dai-chua-te.jpg', 55000, 1, 'Đại thiên thế giới, nơi các vị diện giao nhau, vạn tộc hiện lên như nấm, quần hùng tụ hội, một vị Thiên chi chí tôn đến từ hạ vị diện tại vô tận thế giới diễn lại một truyền kỳ mà mọi người hướng tới, theo đuổi con đường Chúa tể.\r\n\r\n- Hỏa vực vô tận, Viêm Đế nắm giữ, vạn hỏa đốt trời xanh. Trong võ cảnh, Võ Tổ chi uy, chấn nhiếp càn khôn. Bắc Hoang khâu, Vạn Mộ địa, Bất Tử chi chủ trấn thiên địa. Tây Thiên điện, Bách Chiến chi hoàng, chiến uy không thể địch.\r\n\r\n- Thiếu niên bước ra từ Bắc Linh cảnh, cưỡi Cửu U Minh Tước xông đến thế giới hỗn loạn đầy đặc sắc, con đường Chúa tể, ai nổi ai chìm? Đại thiên thế giới, vạn đạo tranh phong, ta làm đại chúa tể.\r\n\r\n- Ở truyện mới này của Lão Đậu, chúng ta có thể gặp lại Viêm Đế Tiêu Viêm, Huân Nhi, hay Lâm Động trong vũ động càn khôn hay không? Mời bạn đọc cùng tìm hiểu.', 'Internet', 100, 1, 'ĐẠI CHÚA TỂ', 1, '2022-08-15 14:07:29'),
(11, 'nhungngaythoau.jpg', 30000, 1, 'Những ngày thơ ấu của nhà văn Nguyên Hồng là một tác phẩm vô cùng hay và ý nghĩa. Nó có lẽ là hồi kí viết về tuổi thơ của tác giả. Một câu chuyện tuổi thơ để lại nhiều suy nghĩ cho người đọc. Chú bé Hồng thật vô cùng đáng thương khi sống trong tuổi thơ thiếu thốn tình yêu thương của mẹ, thứ tình cảm thiêng liêng và cao quý nhất mà đứa trẻ nào cũng cần được có. Câu chuyện đã làm người đọc như muốn được cười, được khóc luôn cùng nhân vật. Quả là một câu chuyện ý nghĩa.', 'Kim Đồng', 300, 11, 'NHỮNG NGÀY THƠ ẤU', 5, '2022-08-15 14:11:42'),
(12, 'lang.jfif', 10000, 1, 'Tình yêu làng quê và lòng yêu nước cũng như tinh thần kháng chiến của người nông dân Việt Nam phải rời làng đi tản cư đã được khắc họa chân thực qua hình ảnh ông Hai trong truyện ngắn Làng của nhà văn Kim Lân.', 'Trẻ', 300, 4, 'LÀNG', 5, '2022-08-15 14:13:51'),
(13, 'conchoxauxi.jfif', 20000, 1, 'Con chó xấu xí là truyện ngắn của nhà văn Kim Lân được in trong tập truyện cùng tên và xuất bản lần đầu năm 1962. Tác phẩm kể về số phận của con chó đáng thương, vì vẻ ngoài xấu xí mà bị ghét bỏ nhưng vẫn trung thành với chủ, trái ngược với một số thành phần trong xã hội thời bấy giờ, sống lười biếng và trốn tránh trách nhiệm.', 'Kim Đồng', 300, 4, 'CON CHÓ XẤU XÍ', 5, '2022-08-15 14:15:52'),
(14, 'doraemonfull.jfif', 300000, 1, 'Doraemon (tiếng Nhật: ドラえもん [doɾaemoɴ]) là một series manga của Nhật Bản do Fujiko F. Fujio sáng tác từ tháng 12 năm 1969 đến tháng 4 năm 1996 đăng trên tạp chí CoroCoro Comic của nhà xuất bản Shogakukan. Có tổng cộng 821 chương truyện được tuyển chọn đóng gói đưa vào 45 tập tankōbon dưới ấn hiệu Tentōmushi Comics cũng do Shogakukan xuất bản; manga đã được dịch và xuất bản bằng nhiều ngôn ngữ trên thế giới bao gồm cả tiếng Việt của Nhà xuất bản Kim Đồng.\r\n\r\nNội dung series kể về cuộc đời bất hạnh của cậu bé Nobita và chú mèo máy Doraemon từ tương lai đến để giúp cuộc sống của cậu bé trở nên tốt hơn. ', 'Trẻ', 30, 1, 'BỘ TRUYỆN DORAEMON FULL', 6, '2022-08-15 14:20:17'),
(15, 'doraemon1.jfif', 20000, 1, 'Doraemon (tiếng Nhật: ドラえもん [doɾaemoɴ]) là một series manga của Nhật Bản do Fujiko F. Fujio sáng tác từ tháng 12 năm 1969 đến tháng 4 năm 1996 đăng trên tạp chí CoroCoro Comic của nhà xuất bản Shogakukan. Có tổng cộng 821 chương truyện được tuyển chọn đóng gói đưa vào 45 tập tankōbon dưới ấn hiệu Tentōmushi Comics cũng do Shogakukan xuất bản; manga đã được dịch và xuất bản bằng nhiều ngôn ngữ trên thế giới bao gồm cả tiếng Việt của Nhà xuất bản Kim Đồng.\r\n\r\nNội dung series kể về cuộc đời bất hạnh của cậu bé Nobita và chú mèo máy Doraemon từ tương lai đến để giúp cuộc sống của cậu bé trở nên tốt hơn. ', 'Trẻ', 100, 1, 'DORAEMON TRUYỆN NGẮN TẬP 1', 6, '2022-08-15 14:22:13'),
(16, 'doraemon-tap-10_1.jpg', 20000, 1, 'Doraemon (tiếng Nhật: ドラえもん [doɾaemoɴ]) là một series manga của Nhật Bản do Fujiko F. Fujio sáng tác từ tháng 12 năm 1969 đến tháng 4 năm 1996 đăng trên tạp chí CoroCoro Comic của nhà xuất bản Shogakukan. Có tổng cộng 821 chương truyện được tuyển chọn đóng gói đưa vào 45 tập tankōbon dưới ấn hiệu Tentōmushi Comics cũng do Shogakukan xuất bản; manga đã được dịch và xuất bản bằng nhiều ngôn ngữ trên thế giới bao gồm cả tiếng Việt của Nhà xuất bản Kim Đồng.\r\n\r\nNội dung series kể về cuộc đời bất hạnh của cậu bé Nobita và chú mèo máy Doraemon từ tương lai đến để giúp cuộc sống của cậu bé trở nên tốt hơn. ', 'Internet', 200, 1, 'DORAEMON TRUYỆN NGẮN TẬP 10', 6, '2022-08-15 14:23:24'),
(17, 'thienlong.jpg', 60000, 1, 'Thiên long bát bộ (giản thể: 天龙八部; phồn thể: 天龍八部; bính âm: Tiān Lóng Bā Bù) là một tiểu thuyết võ hiệp của nhà văn Kim Dung. Tác phẩm được bắt đầu được đăng trên tờ Minh báo ở Hồng Kông và Nam Dương thương báo ở Singapore vào ngày 3 tháng 9 năm 1963 đến ngày 27 tháng 5 năm 1966, liên tục trong 4 năm.[1] Nội dung \"Thiên long bát bộ\" thấm đượm tinh thần Phật giáo mà Kim Dung vốn ngưỡng mộ, tiếng nói của Phật giáo trong tác phẩm vừa dịu dàng sâu lắng vừa thật hiển minh, quán xuyến từ đầu chí cuối tác phẩm.[1] Các nhân vật chính trong tiểu thuyết được dựa trên Bát bộ chúng, là tám loài hữu tình trong thần thoại Phật giáo bao gồm: Thiên, Long, Dạ Xoa, Càn Thát Bà, A Tu La, Ca Lâu La, Khẩn Na La và Ma Hầu La Già.', 'Internet', 140, 2, 'Thiên long bát bộ', 2, '2022-08-15 14:27:29'),
(18, 'chipheo.jpg', 20000, 1, 'Chí Phèo là một truyện ngắn nổi tiếng của nhà văn Nam Cao viết vào tháng 2 năm 1941. Chí Phèo là một tác phẩm xuất sắc, thể hiện nghệ thuật viết truyện độc đáo của Nam Cao, đồng thời là một tấn bi kịch của một người nông dân nghèo bị tha hóa trong xã hội. Chí Phèo cũng là tên nhân vật chính của truyện.', 'Kim Đồng', 90, 3, 'Chí Phèo', 5, '2022-08-15 20:25:31'),
(19, 'ba-vuong-thuong.jpg', 40000, 1, 'Bá Vương thương, là cây thương độc nhất vô nhị trên giang hồ, dài một trượng ba thước bảy thốn ba phân, nặng bảy mươi ba cân bảy lạng ba tiền, toàn thân đều bằng thép ròng. Chủ nhân của nó, tổng tiêu đầu Đại Vương tiêu cục, Vương Vạn Vũ cũng được công nhận là cao thủ thương pháp bậc nhất võ lâm, vậy mà lại chết không minh bạch bởi một cây thương tầm thường…\r\n\r\nVương đại tiểu thư, mang theo cây Bá Vương thương gia truyền, hành tẩu giang hồ, liên tục thách đấu với các cao thủ thương pháp, hòng tìm ra được hung thủ đã sát hại cha mình.\r\n\r\nVận mệnh đã sắp xếp cho hai kẻ lập trường đối nghịch là cường đạo Đinh Hỷ cùng tổng tiêu đầu Đặng Định Hầu gặp nhau hòng vạch trần bí mật về một vụ cướp tiêu bí ẩn, để rồi cùng bị cuốn vào một trận phong ba không ai có thể tưởng tượng được. Bí mật bao trùm bí mật. Có ai ngờ việc điều tra vụ cướp tiêu lại dẫn đến một loạt những bí ẩn khác, mà khởi nguồn là cái chết của Bá Vương Thương Vương Vạn Vũ…', 'Internet', 30, 7, 'BÁ VƯƠNG THƯƠNG', 2, '2022-08-15 20:27:19'),
(20, 'anh-hung-vo-le.jpg', 40000, 1, '“Anh hùng vô lệ” là một bộ tiểu thuyết nói về câu chuyện của những người anh hùng, nhân vật trong sách rất nhiều, vậy rốt cuộc ai là anh hùng? Từ trước đến tiểu thuyết của Cổ Long tiên sinh đều đem đến cho độc giả triết lý sâu sắc làm nên hồn của tác phẩm. Luận anh hùng, cuối cùng thì ai mới là anh hùng?', 'Internet', 50, 7, 'ANH HÙNG VÔ LỆ', 2, '2022-08-15 20:28:39'),
(21, 'co-lau-quai-kiet.jpg', 40000, 1, 'Bắc Ðẩu Thư Sinh Gia Cát Nghị nổi tiếng võ lâm với kiến văn quảng bát của mình nhưng chỉ sau một đêm Tiềm Long Bảo đã trở thành hoang phế, cả nhà Bắc Ðẩu Thư Sinh đột nhiên mất tích.\r\n\r\nBa năm sau, Gia Cát Ngọc xuất hiện trên giang hồ với Kim Cô Lâu lệnh bài truy sát kẻ thù đã vây đánh sư phụ chàng và lật lại vụ án Tiềm Long Bảo. Dưới Truy hồn đoạt mệnh Kim Cô Lâu chưa ai có thể thoát chết bao giờ....', 'Internet', 200, 7, 'CÔ LÂU QUÁI KIỆT', 2, '2022-08-15 20:30:23'),
(22, 'co-gai-man-chau.jpg', 40000, 1, 'Cô Gái Mãn Châu là 1 tác phẩm lớn của tác gia Độc Cô Hồng viết về cuộc tranh giành của nhân dân TQ trong thời ký đói khổ.\r\n\r\nXuyên suốt truyện là cuộc chiến đấu cả về võ thuật lẫn đấu trí...\r\n\r\nVà bây giờ chúng ta cùng đọc truyện nào.', 'Internet', 30, 7, 'CÔ GÁI MÃN CHÂU', 2, '2022-08-15 20:31:52'),
(23, 'cau-vong-khach.jpg', 30000, 1, 'Ở ngôi làng cổ mộ liên tiếp xảy ra nhiều vụ án mạng nên đã tìm tới Thầy Vĩnh nhờ thầy điều tra   vụ án kì lạ của ông trưởng làng, tìm đến tận Khánh Hòa. \r\n\r\nỞ nơi đây có một cây cầu dẫn sang hòn đảo, chứa đựng những vụ tự vẫn kì lạ do một thế lực tâm linh hiểm ác đứng phía sau gây ra. Để giải quyết được điều này, thầy Vĩnh phải đối mặt với nỗi sợ hãi sâu thẳm của mình. Liệu chuyện gì sẽ xảy ra...?', 'Internet', 40, 5, 'CẦU VONG KHÁCH', 3, '2022-08-15 20:35:05'),
(24, 'nhuc-hong-ngai.jpg', 40000, 1, 'Đây là một siêu phẩm liên quan về bùa ngãi.\r\n\r\nNội dung chính của câu chuyện xoay quanh về một thứ bùa ngãi làm hại mọi người trong cả một đất nước, nhưng không ai biết được điều đó mà giải trừ.\r\n\r\nMọi chuyện bắt đầu từ nhân vật tên là Bách- một người bố có con bị bắt cóc trên con đường tìm lại đứa con trai yêu dấu của mình trong vô vọng. Theo chân Bách cùng lời nhắn bí ẩn của người vợ, những sự thật vượt xa trí tưởng tượng của con người dần hiện ra.\r\n\r\nNhững sự kiện cảm tưởng không liên quan ban đầu sẽ dần hòa quyện vào nhau để ghép nên một bức tranh kinh hoàng. Hãy kiên nhẫn.', 'Internet', 300, 5, 'NHỤC HỒNG NGẢI', 3, '2022-08-15 20:37:58'),
(25, 'bong-trang-trang-nga.jpg', 40000, 1, 'Đây là câu chuyện về tâm linh được sáng tác dựa theo mô phỏng của bài hát Thằng Cuội của ca sĩ Ngọc Hiển. \r\n\r\nTác phẩm đi theo phong cách mới nhưng không kém phần hấp dẫn và li kỳ. Bảo là nhân vật chính của câu chuyện, cậu bé vô tình được nghe kể những bí mật kinh hoàng nằm trong lời bài hát này....', 'Internet', 100, 5, 'BÓNG TRĂNG TRẮNG NGÀ', 3, '2022-08-15 20:39:06'),
(26, 'am-trung-quy.jpg', 20000, 1, 'Nội dung chính của câu chuyện nói về một sinh viên xa nhà phải ở nhà trọ là  Toàn cũng bắt đầu từ ngày đó  cuộc đời cậu gặp nhiều những biến cố xảy đến liên tiếp.\r\n\r\nCậu được tiếp xúc với những thế lực không tồn tại ở thế giới này và qua đó hiểu được câu chuyện của một cuộc đời khác', 'Kim Đồng', 100, 5, 'ÂM TRUNG QUỶ', 3, '2022-08-15 20:40:17'),
(27, 'doc-trung-phong.jpg', 20000, 1, 'Ngoài khơi gió bão đang dồn dập. Cơn bão đó che phủ mọi bí mật nơi hòn đảo Thổ Bình xa xôi. Cùng theo chân Đức,một vị bác sĩ bất đắc dĩ phải tới hòn đảo này để chữa bệnh và khám phá sự thật về cái chết của bố mình. Sau cùng, sự thật lộ ra liên quan cả tới những thực thể tâm linh khủng khiếp. Đức phải làm thế nào để ứng phó với tất cả?', 'Internet', 100, 5, 'ĐỘC TRÙNG PHONG', 3, '2022-08-15 20:41:45'),
(28, 'tap-the-0910.jpg', 20000, 1, '\"Tập thể 09/10\" kể về những sự kiện tâm linh kì dị xảy ra trong một khu tập thể cổ kính giữa lòng Hà Nội, thông qua hồi ức của nhân vật Mai Ly. Bước vào những trang truyện đầu tiên, người đọc sẽ được trở về tuổi thơ cùng những nỗi sợ hãi hư hư thực thực, bao bọc lấy tâm trí, ly kì không thể rời mắt', 'Internet', 150, 6, 'TẬP THỂ 09/10', 3, '2022-08-15 20:43:04'),
(29, 'nghiep-bao-hai-nhi.jpg', 20000, 1, 'Ngã Phật từ bi, nhưng có những tội ác, tội nghiệt nặng đến mức trời đất không thể dung tha, dù có sám hối cũng không đạt được tha thứ...\r\n\"Đức Phật từ bi, ngài có thể rộng lượng mà tha thứ kể cả khi có kẻ giết mình. Cho nên có quan niệm cho rằng tội ác thứ 3 phải là: Giết con.\" \r\nMột đứa trẻ phải mất 300 năm nhân duyên mới được đầu thai làm kiếp người. Và nó phải có một sợi dây Tiền Kiếp với người mẹ, người cha đã tạo ra nó. Khoảng thời gian 300 năm có khi còn lâu hơn rất nhiều. \r\nNhưng....\r\nNhân Duyên đó dường như đôi khi lại biến thành Nghiệt Duyên vì chúng bị chối bỏ bởi chính Người Mẹ của mình. Linh hồn của những đứa trẻ chưa kịp ra đời đã bị Giết Chết, bị Bỏ Rơi nơi bãi rác, nơi gầm cầu sẽ ra sao...!? Liệu rằng những bậc sinh thành sẽ phải chịu nhân quả, báo ứng như thế nào sau hành động của mình. \r\nHãy cùng đọc Nghiệp Báo Hài Nhi để cảm nhận.', 'Internet', 100, 6, 'NGHIỆP BÁO HÀI NHI', 3, '2022-08-15 20:46:05'),
(30, 'co-gai-lai-do.jpg', 30000, 1, 'Một câu chuyện có đủ yếu tố ma quái, đan xen chút tình cảm, không thiếu những tình huống ly kỳ, lại càng không thể bỏ qua những tình tiết trinh thám, phá án....mọi thứ đều có đủ trong \"Cô gái lái đò\".', 'Internet', 103, 6, 'CÔ GÁI LÁI ĐÒ', 3, '2022-08-15 20:47:14'),
(31, 'ngai-hai-nhi.jpg', 20000, 1, 'Bạn đọc yêu thích những câu chuyện ma quái, tâm linh, có yếu tố kỳ bí chắc hẳn cũng không cảm thấy xa lạ với bùa và ngải... Ngải là một thứ nguyền rủa, khá âm độc,....và những người nuôi ngải dĩ nhiên cũng có mưu mô, tư lợi riêng...\r\nĐối với Vân, từ khi cha cô qua đời, cuộc sống của cô bỗng rơi vào khủng hoảng. Mẹ cô bắt đầu một cuộc hôn nhân mới bạn thân của chồng. Và cha dượng của Vân không phải một người bình thường, ông nuôi ngải, loại ngải tàn ác, hiểm độc...và từ đó bắt đầu cho hàng loạt cái chết từ những người xung anh Vân\r\nLiệu Vân có tìm được người giúp đỡ, để cô thoát khỏi cuộc sống u ám, lạnh lẽo với nỗi sợ hãi bao trùm. Hãy đọc Ngải Hài Nhi để biết thêm về tâm linh, để cảm nhận cuộc sống: Ma Quỷ đôi khi không đáng sợ Con Người mới thực sự là Độc nhất.', '', 104, 6, 'NGẢI HÀI NHI', 3, '2022-08-15 20:48:27'),
(32, 'am-trung-quy.jpg', 20000, 1, 'Giới thiệu nội dung:\r\n\r\nĐây là câu chuyện cả Việt Nam về cương thi, hay gọi bằng cái tên quen thuộc hơn: quỷ nhập tràng.\r\n\r\nCó lẽ nghe tới quỷ, mọi người sẽ nghĩ đây là một bộ truyện kinh dị. Nhưng thật ra, khi bạn càng đọc về sau, bạn sẽ càng nhận rõ những tình cảm khác trong truyện: tình cảm gia đình, tình mẫu tử, tình thầy trò,... tất cả sẽ đọng lại trong từng chap truyện của Người Mẹ Quỷ…\r\n\r\nNgoài những yếu tố kinh dị, ly kỳ, hấp dẫn, truyện còn mang một thứ gì đó hơi hướng nói về Tình Người. ', 'Internet', 104, 6, 'NGƯỜI MẸ QUỶ', 3, '2022-08-15 20:50:19'),
(33, 'tieng-khoc-am-hon.jpg', 30000, 1, 'Truyện xoay quanh một nhân vật hoàn toàn mới, một nhân vật chẳng liên quan đến bộ truyện nào trước đây cả. Lần này truyện sẽ kết hợp giữa bối cảnh thành phố cũng như vùng thôn quê dân dã. Có những con người trẻ tuổi sống hiện đại, bên cạnh đó là những người từ thế hệ trước, tất cả hi vọng sẽ tạo nên một điều gì đó khác biệt. Nhân vật chính của chúng ta tên là Phú. Thanh niên định cư với gia đình bên Đức 5 năm, sau 5 năm đột nhiên Phú muốn quay về Việt Nam để sinh sống. Quá khứ 5 năm về trước đã xảy ra biến cố gì để phải khiến bố mẹ Phú vội vàng đưa con sang nước ngoài, bỏ lại tất cả ở Việt Nam.\r\n\r\nNhững ám ảnh trong ký ức hỗn loạn của Phú là từ đâu…? Rốt cuộc “ bóng ma “ là thứ gì khiến chàng thanh niên 23 tuổi không thể ngủ ngon ngay khi vừa quay trở lại Việt Nam.', 'Internet', 40, 6, 'TIẾNG KHÓC ÂM HỒN', 3, '2022-08-15 20:51:40'),
(34, 'nghe-nuoi-gai.jpg', 20000, 1, 'Ngay từ tiêu đề truyện, mọi người chắc hẳn đã đoán được câu chuyện này sẽ nói về vấn đề gì... Vẫn là một cái \"nghề\" muôn thuở đủ loại chê trách, nhục mạ, khinh bỉ,...cái nghề trao đổi thân xác và dục vọng để mưu sinh. Tác giả đã viết nên câu chuyện này dựa trên những kinh nghiệm thực tế của bản thân, mô tả cuộc sống của những cô gái \"làm đĩ\"...', 'Internet', 52, 6, 'NGHỀ NUÔI GÁI', 3, '2022-08-15 20:53:01'),
(35, 'mieu-hoang.jpg', 30000, 1, 'Hành trình của một thầy bùa lang bạt trên khắp mọi vùng đất của Việt Nam. Khi ông dừng chân lại tại một ngôi làng thì phát hiện ra ngay tại ngôi làng này có những điều kỳ lạ. Quá khứ của ngôi làng đã xảy ra biến cố gì mà đến tận thời gian này, chướng khí, tai ương mới bắt đầu xuất hiện. Những người dân trong làng rốt cuộc đã phạm phải một sai lầm nghiêm trọng đến đâu để bây giờ họ đang phải gánh nghiệp..?\r\n\r\nLiệu với khả năng của mình, thầy Lương có thể giải mã những bí ẩn, những nguyên do đã bị thời gian phủi quên và cứu được những con người vô tội.', 'Internet', 203, 6, 'MIẾU HOANG', 3, '2022-08-15 20:54:39'),
(36, 'bo-oi-lay-vo-di.jpg', 30000, 1, 'Bộ truyện tâm lý xã hội viết về gia đình cái Còi, một con bé thiếu vắng tình thương của mẹ khi còn đỏ hỏn...!!\r\n\r\nVậy mẹ nó đã đi đâu, làm gì..!?\r\n\r\nCuộc sống của hai bố con những năm tháng sau đó tiếp diễn ra sao khi anh Luân, một người chồng mất vợ phải làm thân Gà Trống Nuôi Con.\r\n\r\nMọi người thường chỉ than thân trách phận cho người phụ nữ nhưng đâu đó trong xã hội này vẫn có những cám cảnh Nam Nhi đầy khổ hạnh...!! Cùng đọc và cảm nhận.', 'Internet', 23, 6, 'BỐ ƠI LẤY VỢ ĐI', 3, '2022-08-15 20:58:09'),
(37, 'than-dieu-hiep-lu.jpg', 20000, 1, '- Thần điêu hiệp lữ là một tiểu thuyết võ hiệp của Kim Dung, còn có tên khác là Thần Điêu đại hiệp. Tác phẩm được đăng tải lần đầu tiên trên tờ Minh báo vào ngày 20 tháng 5 năm 1959 và liên tục trong ba năm. Thần điêu hiệp lữ là phần hai trong bộ Xạ điêu tam bộ khúc, được đánh giá là tiểu thuyết võ hiệp viết về tình yêu hay nhất của Kim Dung.\r\n\r\nBối cảnh của Thần điêu hiệp lữ là vào cuối thời Nam Tống, khi quân Mông Cổ đã lớn mạnh, tiêu diệt hầu hết châu Á, châu Âu, đang trực tiếp uy hiếp an nguy của Nam Tống. Câu chuyện xoay quanh tình yêu của hai nhân vật chính là Dương Quá và Tiểu Long Nữ giữa những cuộc chiến tang thương đẫm máu cả trên giang hồ lẫn chiến trường.\r\n- Nhân vật chính: Dương Quá: Thần Điêu Hiệp Lữ - ngoài ra ở đỉnh Hoa Sơn - Kế thừa Nghĩa phụ Tây Độc - Thiên hạ ngũ tuyệt, Dương Quá còn có ngoại hiệu Tây Cuồng. Tiểu Long Nữ - Là sư phụ dạy võ công cho Dương Quá, nhưng về sau trở thành thê tử.', 'Internet', 49, 2, 'THẦN ĐIÊU HIỆP LỮ', 2, '2022-08-15 20:59:29'),
(38, 'bach-ma-khieu-tay-phong.jpg', 30000, 1, '\"Nếu như ngươi yêu thương say đắm một người, người đó lại yêu thương say đắm một người khác, thì phải thế nào?\"\r\nTình yêu không thể cưỡng cầu được… Trên sa mạc đất Hồi Cương có một đôi vợ chồng người Hán ngã xuống đúng như câu \"Uyên Ương Đồng Mệnh\" khi bị Lã Lương tam kiệt truy sát vì một tấm bản đồ là \"Cao Xương Mê Cung\". Đứa con gái nhỏ của hai người là Lý Văn Tú được con bạch mã đưa tới bộ tộc Cáp Tát Khắc và được một lão nhân họ Kế cứu sống. Cũng tại bộ tộc này Lý Văn Tú đã vướng vào một mối tình tay ba, vậy nàng ta đã xử sự như thế nào? Sư phụ nàng là người Hán hay người của bộ tộc Cáp Tát Khắc, Lão Kế đích thực là ai? Kho báu của Cao Xương có gì mà khiến cho nhiều người đổ máu?\r\n\r\nQua bộ \"Bạch Mã Khiếu Tây Phong\" mọi người sẽ được theo dõi diễn biến tâm trạng của một kẻ khi yêu, đồng thời cũng thấy được tấm lòng chân thực, chất phác của những con người nơi sa mạc…', 'Internet', 40, 2, 'BẠCH MÃ KHIẾU TÂY PHONG', 2, '2022-08-15 21:01:46'),
(39, 'tuyet-son-phi-ho.jpg', 40000, 1, 'Tuyết Sơn Phi Hồ xảy ra trong bối cảnh tranh giành bảo đao của Sấm Vương Lý Tự Thành vào năm Càn Long thứ 48 đời nhà Thanh.\r\n\r\nMiêu Nhân Phụng trở thành nhân vật lẫy lừng trong chốn võ lâm với danh tiếng “Đi khắp thiên hạ kiếm hiệp không địch thủ”. Hồ Phỉ trẻ tuổi đã vang danh với ngoại hiệu Tuyết Sơn Phi Hồ, với cơ trí, võ công chữ Phi Hồ do “phi thiên hồ ly” (cáo bay trên trời) để ca ngợi hình ảnh tuổi trẻ tài cao.\r\n\r\nTuyện hơn một trăm năm trước, vệ sĩ của Sấm Vương gồm họ Hồ, Miêu, Điền, Phạm vì tranh nhau để gây oán thù cho con cháu', 'Kim Đồng', 30, 2, 'TUYẾT SƠN PHI HỒ', 2, '2022-08-15 21:02:45'),
(40, 'hiep-khach-hanh.jpg', 40000, 1, 'Mười tám năm một lần, Thưởng Thiện Phạt Ác Lệnh cùng thiệp mời của đảo Hiệp khách lại xuất hiện. Không ai biết đảo Hiệp khách ở đâu. Cũng không biết đảo chủ là ai. Chỉ biết người của đảo Hiệp khách võ công rất cao cường. Những kẻ kháng lại mời đều bị trừng phạt một cách thảm khốc. Những người phó hội thì biệt vô âm tín. Tính từ lần đầu tiên kể đã 36 năm trôi qua, tất cả tiền bối võ lâm nhận lời đến đảo Hiệp khách đều chưa thấy trở về, không biết sống chết ra sao.\r\n\r\nThiệp mời lần thứ 3 kể cũng đã sắp đến ngày hội ngộ võ lâm Trung nguyên. Trong khi đó, bí mật về đảo Hiệp khách cùng số phận các võ lâm cao thủ vẫn còn nằm trong bóng tối. Phải chăng võ lâm Trung nguyên đến hồi mạt vận?', 'Kim Đồng', 50, 2, 'HIỆP KHÁCH HÀNH', 2, '2022-08-15 21:03:28'),
(41, 'loc-dinh-ky.jpg', 30000, 1, 'Câu chuyện xoay quanh một nhân vật chính thủ đoạn, gian manh vô học thức và lười biếng tên gọi Vi Tiểu Bảo. Bảo là con của Vi Xuân Phương kỹ nữ tại Lệ Xuân Viện, một nhà chứa tại Dương Châu. Ngay cả Vi Xuân Phương cũng không biết cha gã là ai, chỉ đặt tên gã là Tiểu Bảo, sau này có người hỏi tới thì gã lấy họ mẹ.', 'Kim Đồng', 200, 2, 'LỘC ĐỈNH KÝ', 2, '2022-08-15 21:04:22'),
(42, 'bich-huyet-kiem.jpg', 40000, 1, 'Cuối đời nhà Minh, triều đình mục nát, gian thần hoành hành, dân tình thống khổ. Viên đại tướng quân bị tên thái giám gian tặc Ngụy Trung Hiền hãm hại mà thác oan. Các bộ tướng của ông hết lòng phụ tá con ông là Viên Thừa Chí, ước một ngày nào đó giang sơn sẽ yên bình trở lại.', 'Kim Đồng', 100, 2, 'BÍCH HUYẾT KIẾM', 2, '2022-08-15 21:05:16'),
(43, 'tieu-ngao-giang-ho.jpg', 50000, 1, 'Đàn tội tình gì mà phải phân chia... chính tà?\r\n\r\nÐàn của Lưu Chính Phong đành phải đi tìm tiếng sáo của Khúc Dương trưởng lão Ma Giáo, tạo thành một bi hùng kịch cho võ lâm.\r\n\r\nLệnh Hồ đại ca ơi! Người không hề biết mảy may về âm nhạc, nhưng người đã mang khúc \"chính tà\" này đi tấu cho cả võ lâm nghe, đã làm Bắc đẩu võ lâm chau mày, đã làm Minh chủ Ngũ Nhạc lao đao, đã làm vị \"giang hồ trường trị\" ngã gục, và đã đưa người chính kẻ tà phải chau mày hổ thẹn.\r\n\r\nXin mời các cao thủ bước vào để cùng nhau tấu khúc \"tiếu ngạo giang hồ\".', 'Kim Đồng', 30, 2, 'TIẾU NGẠO GIANG HỒ', 2, '2022-08-15 21:07:31'),
(44, 'anh-hung-xa-dieu.jpg', 50000, 1, 'Quách Tỉnh tuy được bảy quái nhân nuôi dưỡng truyền thụ võ công, nhưng khi trưởng thành lại hành hiệp trượng nghĩa.\r\nTrái lại với Quách Tỉnh, Dương Khang tuy được \"Toàn Chân\" thất tử thu nhận làm đồ đệ, hết lòng dạy dỗ, nhưng lớn lên lại gian hiểm, ác, hãm hại chết cả cha ruột của mình.\r\nCon người hắn độc ác, kể cả đối với người thân của mình...', 'Kim Đồng', 100, 2, 'ANH HÙNG XẠ ĐIÊU', 2, '2022-08-15 21:08:53'),
(45, 'thu-kiem-an-cuu-luc.jpg', 40000, 1, 'Hồng Hoa Hội, một bang hội có tổ chức vô cùng rộng lớn với tôn chỉ \"phản Thanh phục Minh\". Sau khi lão hội chủ chẳng may qua đời, mọi người đều đồng lòng tôn Trần Gia Cách lên làm hội chủ. Trần Gia Cách, một bậc tài hoa vô song thân thế lại vô cùng bí ẩn\r\n\r\nTứ đương gia của Hồng Hoa Hội Bôn Lôi Thủ Văn Thái Lai vì mang trong mình một bí mật vô cùng trọng đại nên bị triều đình truy nã ráo riết...\r\n\r\nThân thế của Trần Gia Cách như thế nào và Văn Thái Lai nắm giữ bí mật gì mà lại bị truy tầm gắt gao như vậy?', 'Kim Đồng', 145, 2, 'THƯ KIẾM ÂN CỪU LỤC', 2, '2022-08-15 21:10:17'),
(46, 'cuc-pham-gia-dinh.jpg', 50000, 1, 'Là một tuyệt tác Sắc Hiệp - Xuyên Không được tác giả Vũ Nham sáng tác và hoàn thành vào năm 2008. Sức cuốn hút của Cực Phẩm Gia Đinh thậm chí còn vượt qua Tru Tiên, Thần Mộ và nhiều danh tác khác. Từng làm mưa làm gió trên không biết bao nhiêu cộng đồng mạng đam mê Truyện Kiếm Hiệp.\r\n\r\n- Nhân vật chính của truyện là Lâm Vãn Vinh - 24 tuổi, nổi tiếng là hắc mã vương tử bởi sự thông minh, ngoại hình cao to, làn da ngăm đen ưa nhìn, khả năng vẽ tranh và tài ăn nói sắc sảo cũng khả năng sát gái thượng thừa. Sau khi tốt nghiệp Thủ Khoa đại học Bắc Kinh vào làm giám đốc kinh doanh cho một công ty bán hàng. Trong một chuyến đi du lịch núi Thái Sơn, vô tình bị ngã vào khoảng không gian kỳ và rơi vào một thế giới lạ trái ngược hoàn toàn với lịch sử và hiện thực.', 'Internet', 500, 14, 'CỰC PHẨM GIA ĐINH', 4, '2022-08-15 21:18:08'),
(47, 'do-thi-luong-nhan-hanh.jpg', 30000, 1, 'Một người lính đặc chủng trẻ tuổi nhưng do một lần nhiệm vụ thất bại nên bị buộc phải xuất ngũ. Khi xuất ngũ, đó là lúc hắn bắt đầu bước trên con đường đầy màu sắc truyền kỳ. Tiền tài, quyền thế, mỹ nữ, rồi trong vực sâu của dục vọng. Tất cả sẽ có trong tác phẩm này.', 'Internet', 100, 14, 'ĐÔ THỊ LƯƠNG NHÂN HÀNH', 2, '2022-08-15 21:21:57'),
(48, 'duong-chuyen.jpg', 40000, 1, 'Vân Diệp xuyên việt, y tới những năm đầu Trinh Quan thời Đường, đi cùng y chỉ có một con ngựa hoang gặp nạn, y không hiểu quân sự, không hiểu chính trị, y chẳng thể lật tay làm mây úp tay làm mưa, nhưng y định sẵn sẽ làm thay đổi thời đại do kiếm và bút tô vẽ này. Sơ Đường có quá nhiều tiếc nuối, Trường Tôn hoàng hậu chết sớm, công chúa sống xoa hoa dâm dật, huynh đệ tương tàn, Vân Diệp nguyện làm một viên gạch lát nền cho Đại Đường để bù đắp nuối tiếc đó, để Đại Đường thêm tình người, chứ không phải chỉ có quyền lợi chinh phạt lạnh băng.Tiểu thuyết ăn nhanh cũng là tiểu thuyết, dù không giúp bạn tăng trưởng trí tuệ cũng giúp bạn tăng thêm kinh nghiệm, mang tới cho bạn niềm vui. Truyện cứ thong thả mà đọc, cuộc sống chầm chậm trôi qua.\r\n', 'Internet', 200, 15, 'ĐƯỜNG CHUYÊN', 4, '2022-08-15 21:24:38'),
(49, 'tri-tue-dai-tong.jpg', 40000, 1, 'Nếu bạn đã từng đọc Đường Chuyên thì nhất định không thể bỏ qua bộ truyện này. Tuy không vượt qua cái bóng của Đường Chuyên nhưng truyện vẫn đạt top 5 thể loại lịch sử quân sự trên qidian\r\n\r\nHành văn tinh tế, có sự thông hiểu sâu sắc về lịch sử, nhân vật được phác họa một cách tỉ mỉ, tất cả những điều này đã tạo một phong cách Kiết Dữ 2.\r\n', 'Kim Đồng', 30, 15, 'TRÍ TUỆ ĐẠI TỐNG', 4, '2022-08-15 21:26:03'),
(50, 'minh-thien-ha-poster.jpg', 30000, 1, 'Minh mạt lịch sử phân loạn hỗn tạp, có thể nói là một đoạn từ một ít có cường đại cá nhân mị lực người viết thành lịch sử.\r\n\r\nBất luận là Lý Tự Thành, vẫn là trương hiến trung này đó phản nghịch giả, vẫn là Sùng Trinh, Viên sùng hoán, này đó người đương quyền, cũng hoặc là Ngô Tam Quế, cảnh tinh trung này đó kẻ phản bội, mỗi người trên người đều có rất nhiều chuyện xưa, chính là bởi vì có này đó xuất sắc chuyện xưa, minh mạt lịch sử mới trở nên đại khí khởi bàng bạc, gợn sóng phập phồng.\r\n\r\nMuốn đem một đoạn này lịch sử viết hảo, tự nhiên muốn miêu tả ra một đám sống sờ sờ nhân vật, bất luận hắn lập trường như thế nào, chúng ta đứng ở lịch sử sông dài bên cạnh thượng bàng quan, bọn họ bất quá là này sông dài một đóa bọt sóng.\r\nMắt lạnh xem thế giới, chính là chúng ta trước mắt yêu cầu làm sự tình, mắt lạnh xem lịch sử cũng là chúng ta trước mắt sinh hoạt một loại theo đuổi.', 'Kim Đồng', 40, 15, 'Minh Thiên Hạ', 4, '2022-08-15 21:27:49'),
(51, '6889s.jpg', 40000, 1, 'Chúng ta đã tiếp nhận Tổ Tiên di sản, điều này làm cho Trung Hoa huy hoàng rồi mấy nghìn năm, chúng ta là như thế yên tâm thoải mái, chưa bao giờ nghĩ tới phải về về cái kia tại đốt rẫy gieo hạt trong đau khổ tìm kiếm đường ra thời đại. Trở về chúng ta cực khổ Tổ Tiên, cũng từ trong tìm được cố hương chính thức ý nghĩa, chính là quyển sách muốn nói câu chuyện.', 'Kim Đồng', 50, 15, 'Hán Hương', 4, '2022-08-15 21:29:54'),
(52, 'tien-nghich.jpg', 50000, 1, 'Tiên Nghịch là câu chuyện Tiên Hiệp kể về Vương Lâm - một thiếu niên bình thường, may mắn được gia nhập vào một môn phái tu tiên xuống dốc của nước Triệu, vì thiếu linh căn, vì một hiểu nhầm tai hại, vì một khối thiết tinh và nhờ có được một \"Thần Bí Hạt Châu\". Vương Lâm đã bước lên con đường tu tiên và trên con đường này, hắn sẽ đối mặt với chuyện gì?\r\n\r\n- Tu tiên là nghịch thiên hay thuận thiên, là vô tình hay hữu tình? Hãy cùng dõi theo bước chân của Vương Lâm qua 1976 chương Truyện Tiên Nghịch> để biết rõ những điều này bạn nhé!', 'Internet', 100, 12, 'TIÊN NGHỊCH', 1, '2022-08-15 21:31:00'),
(53, 'nhat-niem-vinh-hang.jpg', 70000, 1, 'Nhất niệm thành biển cả, nhất niệm hóa nương dâu.\r\nNhất niệm trảm nghìn Ma, nhất niệm giết vạn Tiên.\r\n\r\nChỉ có niệm của ta... là Vĩnh hằng.', 'Internet', 20, 12, 'NHẤT NIỆM VĨNH HẰNG', 1, '2022-08-15 21:31:47'),
(54, 'cau-ma.jpg', 45000, 1, 'Nếu như các bạn đã từng là fan đọc của Tiên Nghịch, hay từng đọc qua bộ Tiên Nghịch, chắc các bạn không thể nào quên được tác giả Nhĩ Căn, một tác giả tuy mới nhưng bút lực có thể nói là vô cùng vững chắc.\r\n\r\nQua nhiều ngày mong đợi, cuối cùng Nhĩ Căn đã cho ra tác phẩm mới: Cầu Ma.\r\nNhư thế nào là ma? Là người táng tận lương tâm, vì thành công mà không từ thủ đoạn, thậm chí tu hành ma công để thành ma đầu sao?\r\n\r\nNhĩ Căn không nghĩ thế, Nhĩ Căn muốn viết về một MA thật sự, chứ không phải là một ma đầu thô tục âm u.\r\n\r\nVới tác phẩm này, Nhĩ Căn mong muốn truyền đạt đến cho người đọc cuộc sống đầy nhân sinh, một nội dung động lòng người.', 'Internet', 200, 12, 'CẦU MA', 1, '2022-08-15 21:32:41'),
(55, 'nga-duc-phong-thien.jpg', 60000, 1, 'Nếu ta muốn có, thiên không thể không.\r\nNếu ta muốn không, thiên không được có.\r\n\r\nChỉ hai câu văn án đã đủ lên sự bá đạo của nhân vật chính!', 'Internet', 100, 12, 'NGÃ DỤC PHONG THIÊN', 1, '2022-08-15 21:33:32'),
(56, 'thap-the-ac-nu.jpg', 70000, 1, 'Ở thế giới hiện đại thì Tần Trân thân là một kim bài luật sư, trong suy nghĩ của nàng thì chưa bao giờ cho rằng mình là sứ giả pháp luật hay chính nghĩa,niềm yêu thích nhất của nàng chỉ ham tiền, cũng chỉ phục vụ kẻ có tiền, nàng biện hộ cho những kẻ từ phạm tội cưỡng gian, giết người, trùm buôn thuốc phiện đến các loại phần tử tội ác chồng chất thoát án, nàng cũng không cho rằng mình sai, trong lòng nàng, xét tội và báo ứng là việc của thượng đế, cho đến ngày nàng bị tai nạn xe cộ, thật sự gặp được thẩm phán địa ngục.\r\n\r\nThẩm phán nói, nàng chính là thập thế ác nữ, chín kiếp trước đều là hạng người đại gian đại ác, đến kiếp này làm súc sinh còn không đủ tư cách, phải bị ném vào trong mười tám tầng địa ngục, ở luyện ngục tiếp thu vĩnh thế tra tấn.', 'Internet', 400, 12, 'THẬP THẾ ÁC NỮ', 1, '2022-08-15 21:35:53'),
(57, 'vu-dong-can-khon.jpg', 80000, 1, 'Câu chuyện là một trang sách nói về cuộc đời của một tu luyện giả, bên cạnh đó còn miêu tả cuộc sống đời thường, những suy nghĩ bình thường, nhưng nếu như số mệnh đã sắp đặt bản thân phải đi trên một con đường đầy gian khổ và trắc trở thì sao? Con người đặc biệt luôn có số mệnh đặc biệt, bất kể xuất thân, bất kể địa vị. Chúng ta hãy cùng dõi theo những bước chân của họ, không chỉ đơn giản là xem những pha đánh nhau đẹp mắt, hay những chiêu thức tráng lệ, cũng không phải chỉ để bàn luận đến những âm mưu hay kế sách thâm độc, hèn hạ bỉ ổi, tuyệt vời ra sao. Thứ chúng ta cần là một cái gì đó lớn hơn thế, tất cả mọi thứ hòa quyện lại với nhau tạo ra một sự liên kết tuyệt vời, và sự liên kết đó chính là Võ Động Càn Khôn. Còn chờ gì nữa, các bạn hãy nhanh đọc lướt qua phần giới thiệu để cùng đắm mình trong thế giới của Vũ Động Càn Khôn, thưởng thức cái hay và hấp dẫn không thể cưỡng lại của tác phẩm.', 'Internet', 100, 10, 'VŨ ĐỘNG CÀN KHÔN', 1, '2022-08-15 21:37:41'),
(58, 'thon-phe-tinh-khong.jpg', 50000, 1, 'Đây là 1 bộ truyện mới của cà chua thuộc thể loại Khoa Ảo mới mẻ. Nhân vật chính là La Phong luôn muốn cố gắng trở thành 1 võ giả trong thế giới hiện đại tương lai đầy lạ lẫm, loại người đứng trước nguy cơ quái thú. Mở đầu câu chuyện rất hấp dẫn lôi cuốn, qua từng câu văn người đọc sẽ tự nhận biết được bối cảnh của câu chuyện.Nỗ lực, khát khao, có tình có nghĩa, lối hành văn vững chắc sẽ làm bạn nếu đã đọc liền k thể rời mắt, vẫn là cà chua, hãy theo La Phong của chúng ta khám phá ra thế giới vô tận trong vũ trụ tinh không nhé', 'Internet', 200, 9, 'THÔN PHỆ TINH KHÔNG', 1, '2022-08-15 21:39:23'),
(59, 'tuyet-ung-linh-chu.jpg', 30000, 1, 'Ở tỉnh An Dương của đế quốc, có một lãnh địa quý tộc rất nhỏ và tầm thường, gọi là—— Tuyết Ưng Lĩnh!\r\nChuyện cũ sẽ bắt đầu từ nơi này!\r\nSau « Mãng Hoang Kỷ » « Thôn Phệ Tinh Không » « Cửu Đỉnh Kí » « Bàn Long » « Tinh Thần Biến » « Thốn Mang » « Tinh Phong Truyền Thuyết », đây là bộ tiểu thuyết thứ tám của lão Cà Chua!', 'Internet', 122, 9, 'TUYẾT ƯNG LĨNH CHỦ', 1, '2022-08-15 21:40:24'),
(60, 'tinh-than-bien.jpg', 60000, 1, 'Tinh Thần Biến là một tiểu thuyết võ hiệp có nội dung về một câu Truyện Tiên Hiệp hoành tráng kể về người thanh niên Tần Vũ gian khổ tu luyện, vượt hết khó khăn này đến nguy hiểm khác để lên Thần Giới tìm người yêu.\r\nTần Vũ đã gặp duyên kỳ ngộ học được Tinh Thần Biến công pháp của Lôi Vệ, gian khổ tu luyện để làm cho người thân mình an toàn, nhờ sự giúp sức của Lan thúc(chú của người yêu) và Nghịch Ương tiên đế để phi thăng lên tiên giới và thần giới, nhưng rồi tại thần giới tranh đấu với cả nhà thần vương của Lôi Phạt thành và Lôi Phạt thiên tôn, cuối cùng nhờ sự giúp sức của Lôi Mông (sau này là nhị sư huynh của Tần Vũ và cũng là Lâm Lôi trong truyện Bàn Long cùng tác giả) phát triển lên sau này đã sáng tạo ra Tần Mông vũ trụ của riêng mình.', 'Kim Đồng', 40, 9, 'TINH THẦN BIẾN', 1, '2022-08-15 21:42:00'),
(61, 'cuu-dinh-ky.jpg', 50000, 1, 'Đây là bộ truyện thứ năm của Phiên Gia (tự xưng của tác giả). Bốn bộ truyện trước do Phiên Gia viết có ba bộ vốn là Tu chân, Tiên hiệp thể loại, một là tây phương ma huyễn thể loại. Bộ truyện thứ năm này chính là Đông phương huyền ảo thể loại.\r\n\r\n- \"Cửu Đỉnh Ký\" được Phiên Gia suy nghĩ rất lâu và cũng là bộ truyện được Phiên Gia chờ đợi cao nhất. Tin rằng \"Cửu Đỉnh Ký\" sẽ không khiến cho mọi người phải thất vọng.\r\n\r\n- Tags: cuu dinh ky prc full, truyen tien hiep', 'Internet', 40, 9, 'CỬU ĐỈNH KÝ', 1, '2022-08-15 21:42:59'),
(62, 'thon-mang.jpg', 60000, 1, ' Dù gây ra cơn sốt không lớn bằng Bàn Long, nhưng tác phẩm cũng để lại một ấn tượng cho đọc giả. Đây là một tác phẩm của tác giả Ngã Cật Cây Hồng Thị (Lão Cà Chua) nói về võ thuật mang hơi hương đô thị, với tình tiết hấp dẫn cũng sẽ làm cho đọc giả ngây ngất...', 'Internet', 400, 9, 'THỐN MANG', 1, '2022-08-15 21:43:59'),
(63, 'ban-long.jpg', 50000, 1, 'Bàn Long - Chắc hẳn ai đã là fan của thể loại Tiên Hiệp đều biết đến tác phẩm này. Bàn Long đã từng làm mưa làm gió gây ra bao lũ lụt của giới tu chân.\r\n\r\n- Với 1 kết cấu rất hợp lý và logic, những diễn biến bất ngờ làm cho đọc giả phải đắm chìm vào nó. Cốt truyện của Bàn Long diễn ra ở thế giới của các ma pháp sư và kiếm sĩ. Chàng thanh niên Lâm Lôi Ba Lỗ Khắc sinh ra trong gia đình mang dòng máu truyền thừa của Thanh Long tộc trong Tứ đại thần thú gia tộc. Với thiên phú tu luyện kinh người vươn lên, tới đỉnh cao tại Ngọc Lan đại lục sau đó phi thăng đến Chí cao vị diện tranh đấu với các vị chúa tể - những người đứng đầu của các vị diện này...', 'Internet', 50, 9, 'BÀN LONG', 1, '2022-08-15 21:45:03'),
(64, 'thuyhu.jfif', 50000, 1, 'Thủy hử hay Thủy hử truyện (水滸傳), nghĩa đen là \"bến nước\", là một tác phẩm trong bốn tác phẩm lớn của văn học cổ điển Trung Hoa, thường gọi là nhóm Tứ đại danh tác. Tác giả Thủy hử thường ghi là Thi Nại Am; cũng có người cho là của La Quán Trung[cần dẫn nguồn]. Truyện được viết dựa theo sách Đại Tống Tuyên Hòa di sự[1] Cốt truyện chính là sự hình thành và những thành tích của một nhóm người chống triều đình mà trở thành giặc cướp, thường gọi là 108 anh hùng Lương Sơn Bạc', 'Trẻ', 200, 13, 'THỦY HỬ', 2, '2022-08-15 21:47:21'),
(65, 'doraemon-tap-23.jpg', 10000, 1, 'Doraemon (tiếng Nhật: ドラえもん [doɾaemoɴ]) là một series manga của Nhật Bản do Fujiko F. Fujio sáng tác từ tháng 12 năm 1969 đến tháng 4 năm 1996 đăng trên tạp chí CoroCoro Comic của nhà xuất bản Shogakukan. Có tổng cộng 821 chương truyện được tuyển chọn đóng gói đưa vào 45 tập tankōbon dưới ấn hiệu Tentōmushi Comics cũng do Shogakukan xuất bản; manga đã được dịch và xuất bản bằng nhiều ngôn ngữ trên thế giới bao gồm cả tiếng Việt của Nhà xuất bản Kim Đồng.', 'Kim Đồng', 300, 1, 'DORAEMON TRUYỆN NGẮN TẬP 23', 6, '2022-08-15 21:49:55'),
(66, 'R.jfif', 10000, 1, 'Doraemon (tiếng Nhật: ドラえもん [doɾaemoɴ]) là một series manga của Nhật Bản do Fujiko F. Fujio sáng tác từ tháng 12 năm 1969 đến tháng 4 năm 1996 đăng trên tạp chí CoroCoro Comic của nhà xuất bản Shogakukan. Có tổng cộng 821 chương truyện được tuyển chọn đóng gói đưa vào 45 tập tankōbon dưới ấn hiệu Tentōmushi Comics cũng do Shogakukan xuất bản; manga đã được dịch và xuất bản bằng nhiều ngôn ngữ trên thế giới bao gồm cả tiếng Việt của Nhà xuất bản Kim Đồng.', 'Kim Đồng', 100, 1, 'DORAEMON TRUYỆN NGẮN TẬP 20', 6, '2022-08-15 21:51:06'),
(67, 'DUHANHBIENPHUONGNAM.jfif', 10000, 1, 'Doraemon (tiếng Nhật: ドラえもん [doɾaemoɴ]) là một series manga của Nhật Bản do Fujiko F. Fujio sáng tác từ tháng 12 năm 1969 đến tháng 4 năm 1996 đăng trên tạp chí CoroCoro Comic của nhà xuất bản Shogakukan. Có tổng cộng 821 chương truyện được tuyển chọn đóng gói đưa vào 45 tập tankōbon dưới ấn hiệu Tentōmushi Comics cũng do Shogakukan xuất bản; manga đã được dịch và xuất bản bằng nhiều ngôn ngữ trên thế giới bao gồm cả tiếng Việt của Nhà xuất bản Kim Đồng.', 'Kim Đồng', 30, 1, 'DORAEMON TRUYỆN DÀI - NOBITA DU HÀNH BIỂN PHƯƠNG NAM', 6, '2022-08-15 21:53:12'),
(68, 'chu-khung-long-cua-nobita.JPG', 20000, 1, 'Doraemon (tiếng Nhật: ドラえもん [doɾaemoɴ]) là một series manga của Nhật Bản do Fujiko F. Fujio sáng tác từ tháng 12 năm 1969 đến tháng 4 năm 1996 đăng trên tạp chí CoroCoro Comic của nhà xuất bản Shogakukan. Có tổng cộng 821 chương truyện được tuyển chọn đóng gói đưa vào 45 tập tankōbon dưới ấn hiệu Tentōmushi Comics cũng do Shogakukan xuất bản; manga đã được dịch và xuất bản bằng nhiều ngôn ngữ trên thế giới bao gồm cả tiếng Việt của Nhà xuất bản Kim Đồng.', 'Kim Đồng', 100, 1, 'DORAEMON TRUYỆN DÀI - CHÚ KHỦNG LONG CỦA NOBITA', 6, '2022-08-15 21:54:49'),
(69, '388acf0479a253f1a0cd0d304600d745.jpg', 20000, 1, 'Doraemon (tiếng Nhật: ドラえもん [doɾaemoɴ]) là một series manga của Nhật Bản do Fujiko F. Fujio sáng tác từ tháng 12 năm 1969 đến tháng 4 năm 1996 đăng trên tạp chí CoroCoro Comic của nhà xuất bản Shogakukan. Có tổng cộng 821 chương truyện được tuyển chọn đóng gói đưa vào 45 tập tankōbon dưới ấn hiệu Tentōmushi Comics cũng do Shogakukan xuất bản; manga đã được dịch và xuất bản bằng nhiều ngôn ngữ trên thế giới bao gồm cả tiếng Việt của Nhà xuất bản Kim Đồng.', 'Kim Đồng', 100, 1, 'DORAEMON TRUYỆN DÀI - NOBITA VÀ NHỮNG PHÁP SƯ GIÓ BÍ ẨN', 6, '2022-08-15 21:56:28');

-- --------------------------------------------------------

--
-- Table structure for table `tacgia`
--

CREATE TABLE `tacgia` (
  `id` int(11) NOT NULL,
  `anh` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `mota` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `tentacgia` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `tacgia`
--

INSERT INTO `tacgia` (`id`, `anh`, `mota`, `tentacgia`) VALUES
(1, 'fujiko.jfif', 'Tác giả của bộ truyện tranh Doraemon là Fujiko F. Fujio (hay còn gọi là ông 3F), là bút danh chung của hai họa sĩ manga Fujimoto Hiroshi và Abiko Motoo, cha đẻ của Doraemon', 'Fujiko F. Fujio'),
(2, 'kimdung.jfif', 'Kim Dung tên thật là Tra Lương Dung là một trong những nhà văn có tầm ảnh hưởng nhất đến văn học Trung Quốc hiện đại.Ngoài các tiểu thuyết võ hiệp, ông còn viết các truyện lịch sử Trung Quốc. Ông đã được trao tặng nhiều huân chương danh dự.', 'Kim Dung'),
(3, 'namcao.jfif', 'Nam Cao tên khai sinh là Trần Hữu Tri.Ông xuất thân từ một gia đình Công giáo bậc trung. Cha ông là ông Trần Hữu Huệ, làm nghề thợ mộc và thầy lang trong làng. Mẹ ông là bà Trần Thị Minh, vừa là nội trợ, làm vườn, làm ruộng và dệt vải.', 'Nam Cao'),
(4, 'kimlan.jpg', 'Kim Lân - Nguyễn Văn Tài (sinh 1 tháng 8 năm 1920 - mất 20 tháng 7 năm 2007) là một nhà văn Việt Nam. Ông được biết đến với các tác phẩm văn học như Vợ nhặt, Làng. Ông cũng được biết đến qua vai diễn Lão Hạc trong phim Làng Vũ Đại ngày ấy.', 'Kim Lân'),
(5, 'thuclinh.jpg', 'Nhà văn Thục Linh, tên thật là Nguyễn Thục Linh. Là nhà văn viết truyện linh dị nổi tiếng của Việt Nam', 'Thục Linh'),
(6, 'truongle.jpg', 'Tác giả viết truyện linh dị khá nổi tiếng của Việt Nam', 'Trường Lê'),
(7, 'colong.jfif', 'Nhà văn Đài Loan viết tiểu thuyết võ hiệp nổi tiếng. Ông cũng là nhà biên kịch, nhà sản xuất và đạo diễn. Các tác phẩm của ông đã được chuyển thể nhiều lần trên phim truyền hình cũng như điện ảnh.', 'Cổ Long'),
(8, 'duonggiatamthieu.jpg', 'Trương Uy (tiếng Trung: 张威; bính âm: Zhāng wēi, sinh ngày 10 tháng 1 năm 1981), là một tiểu thuyết gia, văn học mạng người Trung Quốc, được biết đến với bút danh Đường Gia Tam Thiếu', 'Đường Gia Tam Thiếu'),
(9, 'ngacat.jpg', 'Tác giả bạch kim trên website Qidian của Trung Quốc hiện nay, mặc dù không giành được danh hiệu Văn Học Mạng chi Vương được tổ chức vào năm 2015 và 2017, nhưng ông vẫn luôn giữ được danh hiệu \"Ngũ đại chí tôn\" trong hai lần bầu cử.', 'Ngã Cật Tây Hồng Thị'),
(10, 'thientamthodau.jpg', 'Thiên Tàm Thổ Đậu, tên thật Lý Hổ, sinh năm 1989, quê quán Tứ Xuyên, là một tác giả tiểu thuyết mạng Trung Quốc, phó chủ tịch hiệp hội tác giả mạng tỉnh Chiết Giang.', 'Thiên Tàm Thổ Đậu'),
(11, 'nguyenhong.jfif', 'Nguyên Hồng (1918–1982), tên khai sinh Nguyễn Nguyên Hồng, là một nhà văn, nhà thơ Việt Nam', 'Nguyên Hồng'),
(12, 'nhican.jpg', 'Nhĩ Căn, là nhà văn cấp Bạch Kim ở Qidian, yêu thích truyện thần thoại xưa cổ điển của Trung Quốc, cũng coi đây là cơ sở, tiến hành sáng tác truyện online. Hiện tại tác giả đã trở thành cờ hiệu của thể loại tiểu thuyết tiên hiệp ở Qidian', 'Nhĩ Căn'),
(13, 'thinaiam.jpg', 'Thi Nại Am, (tiếng Trung: 施耐庵) (1296 - 1370) là một tác giả Trung Quốc, được cho là người biên soạn đầu tiên của Thủy Hử. Người ta biết rất ít thông tin về ông.', 'Thi Nại Am'),
(14, 'vunham.jpg', 'Vũ Nham là tác giả của tiểu thuyết nổi tiếng “Cực Phẩm Gia Đinh”.', 'Vũ Nham'),
(15, 'default-avatar.jpeg', 'Kiết Dữ 2 bằng phong cách nhẹ nhàng, hóm hỉnh nhưng có nền tảng lịch sử sâu dầy đã mang tới làn gió tươi mát cho loại lịch sử quân sự vốn được coi là khô khan, ai có thể viết lịch sử thoải mái mà không tùy tiện như Kiết Dữ 2?', 'Kiết Dữ 2');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` int(11) NOT NULL,
  `avatar` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `diachi` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `hovaten` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `matkhau` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `phanquyen` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `sdt` int(11) NOT NULL,
  `tendangnhap` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `avatar`, `diachi`, `email`, `hovaten`, `matkhau`, `phanquyen`, `sdt`, `tendangnhap`) VALUES
(1, 'R.jfif', 'Hà Nội', 'zedlmhthan@gmail.com', 'Nguyễn Văn Hân', '$2a$10$mqnEnw6Ti3Zj5KheOo8eGOdYEm.G6iADMwKuIg.9P3WblGOPF.TN.', 'ADMIN', 62669790, 'han123'),
(2, 'default-avatar.jpeg', 'Hồ Chí Minh', 'nguyenvanhancoder@gmail.com', 'Nguyễn Hân', '$2a$10$urifa2jlIE/XugR31.a25.Z1VW6D5zkTeZvPTd57JcVQmtrL6rFLm', 'USER', 12454, 'han1234'),
(3, 'colong.jfif', 'Hà Nội', 'kien2972001@gmail.com', 'Phạm Ngọc Kiên', '$2a$10$ywuW0B6iIGcbZw5ion9hiOhj0bqe3eldWbkdtlIZNxDsyiVi7kTS2', 'USER', 231414, 'kien123');

-- --------------------------------------------------------

--
-- Table structure for table `theloai`
--

CREATE TABLE `theloai` (
  `id` int(11) NOT NULL,
  `anh` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `mota` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `tentheloai` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `theloai`
--

INSERT INTO `theloai` (`id`, `anh`, `mota`, `tentheloai`) VALUES
(1, 'xemgame-pham-nhan-tu-tien-vng-7.jpg', 'Tiên hiệp (tiếng Trung: 仙侠) hay tu chân (tiếng Trung: 修真) là một thể loại kỳ ảo của Trung Quốc, bắt nguồn từ hệ thống tu hành của Đạo giáo và chịu ảnh hưởng từ Phật giáo, võ thuật, y học và các yếu tố truyền thống khác của Trung Quốc.', 'Tiên Hiệp'),
(2, 'OIP.jfif', 'Kiếm hiệp là một thể loại của Hoa Ngữ. Truyện kể về cuộc phiêu lưu của những cao thủ, kiếm khách hay còn gọi là hiệp khách sống trên giang hồ. Kiếm hiệp là một thể loại văn học, nhưng sức ảnh hưởng đã lan rộng ra ra nhiều loại hình nghệ thuật khác.', 'Kiếm Hiệp'),
(3, 'OIF.jfif', 'Linh dị là một thể loại truyện hay phim về tâm linh kinh dị. Chúng kể về những chuyện xảy ra trong thế giới tâm linh, như sự xuất hiện của ma quỷ, bùa chú, oan hồn, tà vật.. Thể hiện sự rùng rợn, kịch tính và hồi hộp đến cho người xem, người đọc.', 'Linh Dị'),
(4, 'codai.jpg', 'Thể loại truyện có nhân vật chính vì một lý do nào đó mà được đưa đến một chiều không gian khác hoặc một khoảng thời gian khác, cách rất xa thời không mình đang sống.', 'Xuyên Không '),
(5, 'R.jfif', 'Truyện ngắn là một thể loại văn học. Nó thường là các câu chuyện kể bằng văn xuôi và có xu hướng ngắn gọn, súc tích và hàm nghĩa. Truyện ngắn thường chỉ tập trung vào một tình huống, một chủ đề nhất định. ', 'Truyện Ngắn'),
(6, 'OIP (1).jfif', 'Truyện tranh, hoặc là mạn họa, là một loại sách được sử dụng để thể hiện ý tưởng bằng hình ảnh,thường kết hợp với các văn bản hoặc thông tin hình ảnh khác. ', 'Truyện Tranh');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `phanhoi`
--
ALTER TABLE `phanhoi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `phanhoi`
--
ALTER TABLE `phanhoi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sach`
--
ALTER TABLE `sach`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT for table `tacgia`
--
ALTER TABLE `tacgia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `theloai`
--
ALTER TABLE `theloai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
