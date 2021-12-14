-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.21 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 musicplayer.favormusic 结构
CREATE TABLE IF NOT EXISTS `favormusic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(50) DEFAULT NULL,
  `songid` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 正在导出表  musicplayer.favormusic 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `favormusic` DISABLE KEYS */;
INSERT INTO `favormusic` (`id`, `userid`, `songid`) VALUES
	(1, 'admin', 0),
	(2, 'admin', 1),
	(8, 'admin', 2),
	(9, 'user', 4);
/*!40000 ALTER TABLE `favormusic` ENABLE KEYS */;

-- 导出  表 musicplayer.music 结构
CREATE TABLE IF NOT EXISTS `music` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `singer` varchar(50) DEFAULT NULL,
  `src` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `coverImgUrl` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  musicplayer.music 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
INSERT INTO `music` (`id`, `title`, `singer`, `src`, `coverImgUrl`) VALUES
	(1, '最美的光', '尚琪祺', 'http://music.163.com/song/media/outer/url?id=27908100.mp3', 'https://y.gtimg.cn/music/photo_new/T002R300x300M000002UVhvw0piHPf_5.jpg?max_age=2592000'),
	(2, '成都', '赵雷', 'http://music.163.com/song/media/outer/url?id=436514312.mp3', 'https://y.gtimg.cn/music/photo_new/T001R300x300M000001Lr98T0yEWAk.jpg?max_age=2592000'),
	(3, '归来', '满江', 'http://music.163.com/song/media/outer/url?id=403710591.mp3', 'https://y.gtimg.cn/music/photo_new/T001R300x300M000002Fr8pA1oo1vd.jpg?max_age=2592000'),
	(4, '下雨的杭州', '解忧邵帅', 'http://music.163.com/song/media/outer/url?id=1391433967.mp3', 'http://p2.music.126.net/aKts3SZtKFRAOccJgqOCDg==/109951164369935111.jpg?param=300x300'),
	(5, '会不会（吉他版）', '刘大壮', 'http://music.163.com/song/media/outer/url?id=1481164987', 'http://p1.music.126.net/SFXsIYI3hCCedvbqrvVytA==/109951165335411992.jpg'),
	(6, '囍（女生版）', '等什么君', 'http://music.163.com/song/media/outer/url?id=1496822949', 'http://p2.music.126.net/m4zo-ZytE82l_Mdw3tUrQA==/109951165483970109.jpg?param=130y130'),
	(7, '鲸溺', '聂香_Yuki', 'http://music.163.com/song/media/outer/url?id=1396382563', 'http://p2.music.126.net/1Aog2lXVGERQ__d-EeiSEg==/109951164421522461.jpg?param=130y130');
/*!40000 ALTER TABLE `music` ENABLE KEYS */;

-- 导出  表 musicplayer.tb_user 结构
CREATE TABLE IF NOT EXISTS `tb_user` (
  `name` varchar(16) NOT NULL,
  `password` varchar(16) DEFAULT NULL,
  `age` smallint DEFAULT NULL,
  `gender` char(2) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `education` varchar(4) DEFAULT NULL,
  `interesting` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  musicplayer.tb_user 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`name`, `password`, `age`, `gender`, `email`, `education`, `interesting`) VALUES
	('admin', 'admin', 20, '男', 'admin@qq.com', '本科', '音乐'),
	('user', 'user', 0, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
