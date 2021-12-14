// pages/userinfo/changeinfo/changeinfo.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    username: '',


  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getStorage({
      key: 'username',
      success: function (res) {
        // console.log(res)
        that.setData({
          isLogined: true,
          username: res.data
        })
        // console.log(that.data.username)

        wx.request({
          url: app.globalData.globalReqUrl + 'user',
          data: {
            username: that.data.username,
          },
          success: function (res) {

            that.setData({
              'user.age': res.data.age,
              'user.gender': res.data.gender,
              'user.email': res.data.email,
              'user.education': res.data.education,
              'user.interesting': res.data.interesting
            })

          }
        })
      }
    })


  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */

  onShow: function (e) {

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
  doSave() {
    var that = this
    console.log(that.data.user)
    wx.request({
      url: app.globalData.globalReqUrl + 'user',
      data: {
        username: that.data.username,

        age: that.data.user.age,
        gender: that.data.user.gender,
        email: that.data.user.email,
        education: that.data.user.education,
        interesting: that.data.user.interesting,
        set: true
      },
      success: function (res) {
        console.log(that.data.user.age)
        console.log(res)
        wx.showToast({
          title: "修改成功",
          icon: 'none',
          duration: 2000
        })
      }
    })
  },
  Input: function (e) {
    // console.log(e.currentTarget.dataset.label)
    let label = 'user.' + e.currentTarget.dataset.label
    this.setData({
      [label]: e.detail.value
    })
  }
})