/*
 * Copyright (C) 2009 Manning Publications Co.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.msi.manning.chapter10.simplevideo

import android.app.Activity
import android.os.Bundle
import android.graphics.PixelFormat
import android.view.View
import android.widget.{Button, MediaController, VideoView}

class SimpleVideo extends Activity {

  private var myVideo: VideoView = _
  private var mc: MediaController = _

  override def onCreate(icicle: Bundle) {
    super.onCreate(icicle)
    getWindow setFormat PixelFormat.TRANSLUCENT
    setContentView(R.layout.main)
    val bPlayVideo = findViewById(R.id.playvideo).asInstanceOf[Button]
    bPlayVideo setOnClickListener new View.OnClickListener() {
      def onClick(view: View) {
        mc.show()
      }
    }
    myVideo = findViewById(R.id.video).asInstanceOf[VideoView]
    myVideo setVideoPath "/sdcard/Videos/test.mp4"
    mc = new MediaController(this)
    mc setMediaPlayer myVideo
    myVideo setMediaController mc
    myVideo.requestFocus()
  }
}
