package jp.takke.coilgifcirclecroperrorsample

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import coil.ImageLoader
import coil.api.load
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.transform.CircleCropTransformation

class MainActivity : AppCompatActivity() {

    private val tag = this.javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // setup for coil-gif
        ImageLoader(this) {
            componentRegistry {
                if (SDK_INT >= P) {
                    add(ImageDecoderDecoder())
                } else {
                    add(GifDecoder())
                }
            }
        }

        val imageUrl1 = "https://media.giphy.com/media/PwUCOUoA0XFUA/giphy.gif"
        findViewById<ImageView>(R.id.helloImage1L).load(imageUrl1) {
            listener(onError = {_, throwable ->
                Log.e(tag, imageUrl1, throwable)
            })
        }

        findViewById<ImageView>(R.id.helloImage1R).load(imageUrl1) {
            transformations(CircleCropTransformation())

            listener(onError = {_, throwable ->
                Log.e(tag, imageUrl1, throwable)
            })
        }

        val imageUrl2 = "https://twemoji.maxcdn.com/v/12.1.5/72x72/1f600.png"
        findViewById<ImageView>(R.id.helloImage2L).load(imageUrl2) {
            listener(onError = {_, throwable ->
                Log.e(tag, imageUrl1, throwable)
            })
        }

        findViewById<ImageView>(R.id.helloImage2R).load(imageUrl2) {
            transformations(CircleCropTransformation())

            listener(onError = {_, throwable ->
                Log.e(tag, imageUrl1, throwable)
            })
        }

    }

}
