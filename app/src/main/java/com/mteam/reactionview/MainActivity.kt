package com.mteam.reactionview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ReactionSelectedListener {
    override fun invoke(position: Int): Boolean {
        Toast.makeText(this,position.toString(),Toast.LENGTH_LONG).show()
        return true
    }

    private val strings = arrayOf("like", "love", "laugh", "wow", "sad", "angry")
    private val reaction by lazy {
        ReactionAnimation()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val popup = ReactionPopup(
            this,
            ReactionsConfigBuilder(this)
                .withReactions(
                    intArrayOf(
                        R.drawable.ic_fb_like,
                        R.drawable.ic_fb_love,
                        R.drawable.ic_fb_laugh,
                        R.drawable.ic_fb_wow,
                        R.drawable.ic_fb_sad,
                        R.drawable.ic_fb_angry
                    )
                )
                .withReactionTexts { position -> strings[position] }
                .build(),this)

        text2.setOnClickListener{
            reaction.react(this,it)
        }

        textReaction.setOnTouchListener(popup)
    }
}
