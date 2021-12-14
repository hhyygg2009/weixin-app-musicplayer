//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    isLogined: false,
    currentTab: '0',
    state: 'paused',
    playIndex: 0,
    username: '',
    recentPlay: [],
    favor: [],
    searching:false,
    play: {
      currentTime: '00:00',
      duration: '00:00',
      percent: 0,
      title: '',
      singer: '',
      coverImgUrl: '/images/cover.jpg',
      favor: false
    },
    //   playlist: [{
    //     id: 1,
    //     title: '最美的光',
    //     singer: '尚琪祺',
    //     src: 'http://music.163.com/song/media/outer/url?id=27908100.mp3',
    //     coverImgUrl: 'https://y.gtimg.cn/music/photo_new/T002R300x300M000002UVhvw0piHPf_5.jpg?max_age=2592000'
    //   }, {
    //     id: 2,
    //     title: '成都',
    //     singer: '赵雷',
    //       src: 'http://music.163.com/song/media/outer/url?id=436514312.mp3',
    //     coverImgUrl: 'https://y.gtimg.cn/music/photo_new/T001R300x300M000001Lr98T0yEWAk.jpg?max_age=2592000'
    //   }, {
    //     id: 3,
    //     title: '归来',
    //     singer: '满江',
    //       src: 'http://music.163.com/song/media/outer/url?id=403710591.mp3',
    //     coverImgUrl: 'https://y.gtimg.cn/music/photo_new/T001R300x300M000002Fr8pA1oo1vd.jpg?max_age=2592000'
    //   }, {
    //     id: 4,
    //     title: '下雨的杭州',
    //     singer: '解忧邵帅',
    //       src: 'http://music.163.com/song/media/outer/url?id=1391433967.mp3',
    //     coverImgUrl: '/images/cover.jpg'
    //   },
    //   ]
  },
  onLoad: function () {
    var that = this;
    wx.request({
      url: app.globalData.globalReqUrl+'getMusic',
      success: function (res) {
        // console.log(res)
        that.setData({
          playlist: res.data
        })
      }
    })


    wx.getStorage({
      key: 'recentplay',
      success: function (res) {
        that.setData({
          recentPlay: res.data
        })
      },
      fail: function (e) {
        wx.setStorage({
          data: that.data.recentPlay,
          key: 'recentplay',
          success: function (e) {
            // console.log(e)
          },
          fail: function (e) {
            console.log(e)
          }
        })

      }
    })
  },
  checkLogin: function (e) {
    if (!this.data.isLogined) {
      wx.showToast({
        title: '请登录以使用更多功能',
        icon: 'none',
        duration: 2000
      })
      return false;
    }
    return true;
  },

  recentPlay: function (e) {
    if (this.checkLogin()) {

    }
  },

  favorSong: function (e) {
    if (this.checkLogin()) {

    }
  },

  audioCtx: null,
  onReady: function () {
    this.audioCtx = wx.createInnerAudioContext()
    this.setMusic(0)
    var that = this
    this.audioCtx.onError(function () {
      console.log('播放失败' + that.audioCtx.src)
    })
    this.audioCtx.onEnded(function () {
      that.next()
    })
    this.audioCtx.onPlay(function () {})
    this.audioCtx.onTimeUpdate(function () {
      that.setData({
        'play.duration': formatTime(that.audioCtx.duration),
        'play.currentTime': formatTime(that.audioCtx.currentTime),
        'play.percent': that.audioCtx.currentTime / that.audioCtx.duration * 100
      })
    })

    function formatTime(time) {
      var minute = Math.floor(time / 60) % 60
      var second = Math.floor(time) % 60
      return (minute < 10 ? '0' + minute : minute) + ':' + (second < 10 ? '0' + second : second)
    }
  },

  setMusic: function (index) {
    var recent = this.data.recentPlay;
    if (recent.length == 10) {
      recent.shift()
    }
    var i = recent.indexOf(index)
    if (i > -1&&recent.length>0) {
      recent.splice(i, 1)
    }
    recent.push(index);
    var music ={}
    if(this.data.playlist){
      music = this.data.playlist[index]
      this.audioCtx.src = music.src
    }
    //  console.log(this.data.recentPlay)
    var favor = this.data.favor;
    var isfavor = false
    //  console.log(index.toString())
    if (favor.indexOf(index.toString()) > -1) {
      isfavor = true
    }
    this.setData({
      playIndex: index,
      'play.title': music.title,
      'play.singer': music.singer,
      'play.coverImgUrl': music.coverImgUrl,
      'play.currentTime': '00:00',
      // 'play.duration':'00:00',
      'play.duration': formatTime(this.audioCtx.duration),
      // 'play.duration':this.audioCtx.duration,      
      'play.precent': 0,
      recentPlay: recent,
      'play.favor': isfavor
    })
    wx.setStorage({
      data: recent,
      key: 'recentplay',
      success: function (e) {
        // console.log(e)
      },
      fail: function (e) {
        console.log(e)
      }
    })

    function formatTime(time) {
      var minute = Math.floor(time / 60) % 60
      var second = Math.floor(time) % 60
      return (minute < 10 ? '0' + minute : minute) + ':' + (second < 10 ? '0' + second : second)
    }

    //  console.log(this.audioCtx)
  },


  changeTab: function (e) {
    this.setData({
      currentTab: e.target.dataset.current
    })
  },
  changeSwiperItem: function (e) {
    this.setData({
      currentTab: e.detail.current
    })
  },
  play: function () {
    this.audioCtx.play()
    this.setData({
      state: 'running'
    })
    console.log(this.data.play.title)
  },
  pause: function () {
    this.audioCtx.pause()
    this.setData({
      state: 'paused'
    })
  },
  next: function () {
    var index = this.data.playIndex >= this.data.playlist.length - 1 ? 0 : this.data.playIndex + 1
    this.setMusic(index)
    if (this.data.state === 'running') {
      this.play()
    }
  },
  sliderChange: function (e) {
    var second = e.detail.value * this.audioCtx.duration / 100
    this.audioCtx.seek(second)
  },
  change: function (e) {
    this.setMusic(e.currentTarget.dataset.index)
    // console.log(e.currenTarget.dataset.index)
    this.play()
  },
  login: function (e) {
    wx.navigateTo({
      url: '../user/user',
    })
  },
  onShow: function (e) {
    var that = this;
    wx.getStorage({
      key: 'username',
      success: function (res) {
        // console.log(res)
        that.setData({
          isLogined: true,
          username: res.data
        })

        if (that.data.username != "") {
          wx.request({
            url: app.globalData.globalReqUrl+'getFavor',
            data: {
              'userid': that.data.username
            },

            success: function (res) {
              // console.log(res)
              that.setData({
                favor: res.data
              })
            }
          })
        }
      }
    })
  },
  setFavor: function (insert) {
    if (this.checkLogin()) {
    var that = this;
    if (that.data.username != "") {
      wx.request({
        url: app.globalData.globalReqUrl+'favor',
        data: {
          'userid': that.data.username,
          'songid': that.data.playIndex,
          'insert': insert
        },
        success: function (res) {
          console.log(res)
          that.setData({
            favor: res.data
          })
        }
      })
    }}
  },

  favor: function () {
    
    this.setData({
      'play.favor': true
    })
    this.setFavor(true);
  },
  disfavor: function () {
    this.setData({
      'play.favor': false
    })
    this.setFavor(false);
  },
  search:function(e){
    // wx.navigateTo({
    //   url: './search/search?search='+this.data.search,
    // })
    var that = this;
    console.log(that.data.search)
    wx.request({
      url: app.globalData.globalReqUrl+'getMusic',
      data:{
          title:that.data.search
      },
      success: function (res) {
        console.log(res)
        that.setData({
          playlist: res.data,
          searching:true
        })
      }
    })
  },
  input:function(e){
    this.setData({
      search:e.detail.value
    })
  },
  hideInput:function(e){
    var that=this
    this.setData({
      searching:false
    })
    wx.request({
      url: app.globalData.globalReqUrl+'getMusic',
      success: function (res) {
        // console.log(res)
        that.setData({
          playlist: res.data
        })
      }
    })
  }

})
