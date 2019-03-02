package com.mahadum360.mahadum.ui.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import com.mahadum360.mahadum.R
import com.mahadum360.mahadum.auth.AuthActivity
import com.mahadum360.mahadum.utils.SlideManager

class SlideActivity : AppCompatActivity() {

    private var viewPager: ViewPager? = null
    private val welcomeSlideTextView: TextView? = null
    private val mahadumNamePart: TextView? = null
    private val mahadum360part: TextView? = null
    private var dotsLayout: LinearLayout? = null
    private val mahadumTextLayout: LinearLayout? = null
    private var welcomeMahadumView: ImageView? = null
    private var skipButton: Button? = null
    private var nextButton: Button? = null
    private var signInbutton: Button? = null
    private var signUpbutton: Button? = null
    private var images: IntArray? = null
    private var backgrounds: IntArray? = null
    private var languages: Array<String>? = null

    internal var viewPageChangeListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

        }

        override fun onPageSelected(position: Int) {
            addBottomDots(position)
            if (position == images!!.size - 1) {
                nextButton!!.text = ""
                nextButton!!.visibility = View.GONE
                skipButton!!.text = "Finish"
            } else {
                nextButton!!.text = ">"
                skipButton!!.text = "Skip"
                nextButton!!.visibility = View.VISIBLE
                skipButton!!.visibility = View.VISIBLE
                signInbutton!!.visibility = View.GONE
                signUpbutton!!.visibility = View.GONE
                welcomeMahadumView!!.visibility = View.GONE
            }
        }

        override fun onPageScrollStateChanged(state: Int) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreen()
        setContentView(R.layout.activity_slide)

        //making all the fonts montserrat.
        //changeWidgetsFont();
        val slideManager = SlideManager(this)
        if (!slideManager.check()) {
            val intent = Intent(applicationContext, AuthActivity::class.java)
            intent.putExtra("where", "login")
            startActivity(intent)
            finish()
        }
        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        viewPager = findViewById(R.id.view_pager)
        dotsLayout = findViewById(R.id.layoutDots)
        skipButton = findViewById(R.id.slide_skip)
        nextButton = findViewById(R.id.slide_next)
        signInbutton = findViewById(R.id.slide_welcome_signIn_button)
        signUpbutton = findViewById(R.id.slide_welcome_signUp_button)
        welcomeMahadumView = findViewById(R.id.welcome_mahadum_imgview)
        signInbutton!!.visibility = View.GONE
        signUpbutton!!.visibility = View.GONE
        welcomeMahadumView!!.visibility = View.GONE
        images = intArrayOf(R.drawable.yoruba, R.drawable.igbo, R.drawable.hausa, R.drawable.french, R.drawable.english)
        backgrounds = intArrayOf(R.drawable.bg_gradient1, R.drawable.bg_gradient2, R.drawable.bg_gradient3, R.drawable.bg_gradient4, R.drawable.bg_gradient5)
        languages = arrayOf("Yoruba", "Igbo", "Hausa", "French", "English")
        addBottomDots(0)
        changeStatusBarColor()
        val viewPagerAdapter = ViewPagerAdapter(languages, images, backgrounds!!)
        viewPager!!.adapter = viewPagerAdapter
        viewPager!!.setOnPageChangeListener(viewPageChangeListener)
        skipButton!!.setOnClickListener { v ->
            skipButton!!.visibility = View.GONE
            dotsLayout!!.removeAllViews()
            viewPager!!.visibility = View.GONE
            signInbutton!!.visibility = View.VISIBLE
            signUpbutton!!.visibility = View.VISIBLE
            welcomeMahadumView!!.visibility = View.VISIBLE
            slideManager.setFirst(false)
        }
        nextButton!!.setOnClickListener { v ->
            val currentItemNo = getItem(+1)
            if (currentItemNo < images!!.size) {
                viewPager!!.currentItem = currentItemNo
            }//here currentItemNo == layouts.length hence final page


        }
        signInbutton!!.setOnClickListener { v ->
            val intent = Intent(applicationContext, AuthActivity::class.java)
            intent.putExtra("where", "login")
            startActivity(intent)
            finish()
        }
        signUpbutton!!.setOnClickListener { v ->
            val intent = Intent(applicationContext, AuthActivity::class.java)
            intent.putExtra("where", "register")
            startActivity(intent)
            finish()
        }
    }

    private fun addBottomDots(position: Int) {
        val dots = arrayOfNulls<TextView>(images!!.size)
        val colorActive = resources.getIntArray(R.array.dot_active)
        val colorInActive = resources.getIntArray(R.array.dot_inactive)
        dotsLayout!!.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.setText(".")
            dots[i]!!.setTextSize(35f)
            dots[i]!!.setTextColor(colorInActive[position])
            dotsLayout!!.addView(dots[i])
        }
        if (dots.size > 0) {
            dots[position]!!.setTextColor(colorActive[position])
        }
    }

    private fun getItem(i: Int): Int {
        return viewPager!!.currentItem + 1
    }

    fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    inner class ViewPagerAdapter(private val langauges: Array<String>?, private val images: IntArray?, private val backgrounds: IntArray) : PagerAdapter() {
        private var layoutInflater: LayoutInflater? = null
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val v = layoutInflater!!.inflate(R.layout.slide_screen1, container, false)
            if (langauges != null && langauges.size > position && images != null && images.size > position) {
                (v.findViewById<View>(R.id.language_image) as ImageView).setImageResource(images[position])
                (v.findViewById<View>(R.id.language) as TextView).text = langauges[position]
                v.findViewById<View>(R.id.parent).setBackgroundResource(backgrounds[position])
            }
            container.addView(v)
            return v
        }

        override fun getCount(): Int {
            return images!!.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val v = `object` as View
            container.removeView(v)
        }
    }

    private fun setFullScreen() {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}
