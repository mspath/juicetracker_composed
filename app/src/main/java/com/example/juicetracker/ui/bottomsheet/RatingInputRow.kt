package com.example.juicetracker.ui.bottomsheet

import android.widget.RatingBar
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.juicetracker.R

/**
 * Showing star rating by using RatingBar through AndroidView
 */
@Composable
fun RatingInputRow(rating: Int, onRatingChange: (Int) -> Unit, modifier: Modifier = Modifier) {
    InputRow(inputLabel = stringResource(R.string.rating), modifier = modifier) {
        AndroidView(
            factory = { context ->
                RatingBar(context).apply {
                    stepSize = 1f

                }
            },
            update = { ratingBar ->
                ratingBar.rating = rating.toFloat()
                ratingBar.setOnRatingBarChangeListener { _, _, _ ->
                    onRatingChange(ratingBar.rating.toInt())
                }
            }
        )
    }
}