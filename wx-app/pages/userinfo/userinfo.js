// pages/userinfo.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.setData({
      src: app.globalData.src
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

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
  changeInfo: function (e) {
    if (this.checkLogin()) {
      wx.navigateTo({
        url: './changeinfo/changeinfo',
      })

    }
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
        console.log(res)
        that.setData({
          isLogined: true,
          username: res.data
        })
      }
    })
  },
  showAbout: function (e) {
    wx.showModal({
      title: "关于本程序",
      content: "作者：hhyygg2009",
      success(res) {
        if (res.confirm) {
          console.log('用户点击确定')
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  }

})