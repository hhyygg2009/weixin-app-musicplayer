/*
 * @Author: hhyygg2009
 * @Date: 2020-11-22 13:21:21
 * @LastEditTime: 2021-12-14 18:59:04
 * @LastEditors: hhyygg2009
 * @Description: 
 * @FilePath: \wx-app\pages\index\search\search.js
 * 你所热爱的，就是你的生活
 */
// pages/index/search/search.js
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
    // console.log(options)
    this.setData({
      search: options
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
  onShow: function () {
    var that = this;
    wx.request({
      url: app.globalData.globalReqUrl + 'getMusic',
      data: {
        search: this.data.search
      },
      success: function (res) {
        // console.log(res)
        that.setData({
          playlist: res.data
        })
      }
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

  }
})