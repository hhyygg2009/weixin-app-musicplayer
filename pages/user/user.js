//index.js
//获取应用实例
const app = getApp()
 
Page({
  data: {
    username: '',
    password: '',
    rpassword: '',
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onShow: function () {
    // 生命周期函数--监听页面显示
    // wx.hideTabBar({})
  },
  onLoad: function () {
   
  },
 
 
  // 获取输入账号 
  usernameInput: function (e) {
    this.setData({
      username: e.detail.value
    })
  },
 
  // 获取输入密码 
  passwordInput: function (e) {
    this.setData({
      password: e.detail.value
    })
  },
  rpasswordInput: function (e) {
    this.setData({
      rpassword: e.detail.value
    })
  },
 
  // 登录处理
  doLogin: function () {
    var that = this;
    if (this.data.username.length == 0 || this.data.password.length == 0) {
      wx.showToast({
        title: '账号或密码不能为空',
        icon: 'none',
        duration: 2000
      })
    } else {
      wx.request({
        url: app.globalData.globalReqUrl +'DoLogin', // 仅为示例，并非真实的接口地址
        method: 'post',
        data: {
          username: that.data.username,
          password: that.data.password
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded' // 默认值
        },
        success(res) {
          console.log(res)
          if (res.data.errmsg == "success") {
            wx.setStorageSync('username', that.data.username)

            wx.showToast({
              title: '登录成功',
              icon: 'none',
              duration: 2000
            })
            wx.switchTab({
              url: '../index/index',
              fail:function(e){
                console.log(e)
              }
            })
          } else {            
            wx.showToast({
              title: res.data.errmsg,
              icon: 'none',
              duration: 2000
            })
          }
        }
      })
    }
  },
  doRegister:function(){
    var that = this;
    if (this.data.username.length == 0 || this.data.password.length == 0) {
      wx.showToast({
        title: '账号或密码不能为空',
        icon: 'none',
        duration: 2000
      })
    }else     if (this.data.password!=this.data.rpassword) {
      wx.showToast({
        title: '密码、确认密码不一致',
        icon: 'none',
        duration: 2000
      }) 
    
    }else {
      wx.request({
        url: app.globalData.globalReqUrl +'DoRegister', // 仅为示例，并非真实的接口地址
        method: 'post',
        data: {
          username: that.data.username,
          password: that.data.password
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded' // 默认值
        },
        success(res) {
          console.log(res)
          if (res.data.errmsg == "success") {
            wx.setStorageSync('username', that.data.username)

            wx.showToast({
              title: '注册成功,请登录',
              icon: 'none',
              duration: 2000
            })
            that.setData({
              currentTab:0
            })
          } else {            
            wx.showToast({
              title: res.data.errmsg,
              icon: 'none',
              duration: 2000
            })
          }
        }
      })
    }

  },

  changeTab:function(e){
    this.setData({
      currentTab:e.target.dataset.current
    })
  },
  changeSwiperItem:function(e){
    this.setData({
      currentTab:e.detail.current
    })
  },
})
 