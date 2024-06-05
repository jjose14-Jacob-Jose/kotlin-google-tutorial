package com.stc.woof.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stc.woof.R
import com.stc.woof.data.DataSourceDog
import com.stc.woof.model.Dog
import com.stc.woof.ui.theme.WoofTheme

class ScreenDog {

    @Composable
    fun Show(
        dog: Dog,
        modifier : Modifier = Modifier
    ) {
        var isHobbyVisible by remember { mutableStateOf(false) }
        Card(

        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioHighBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = dog.imageResourceId),
                    contentDescription = stringResource(id = R.string.content_description_image_dog)
                            + stringResource(id = dog.name),
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small))
                        .clip(MaterialTheme.shapes.small),
                    contentScale = ContentScale.Crop
                    
                )
                Column() {
                    Text(
                        text = stringResource(id = dog.name),
                        style = MaterialTheme.typography.displayMedium,
                        modifier = modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
                    )
                    Text(
                        text = stringResource(id = R.string.years_old, dog.age),
                        style = MaterialTheme.typography.bodyLarge,


                    )
                    if (isHobbyVisible) {
                        Text(
                            text = stringResource(id = R.string.about),
                            style = MaterialTheme.typography.titleSmall,
                            modifier = modifier.padding(top = dimensionResource(id = R.dimen.padding_small))

                        )
                        Text(
                            text = stringResource(id = dog.hobby),
                            style = MaterialTheme.typography.bodySmall,

                        )
                    }
                }
                Box(
                    modifier = modifier
                        .padding(end= dimensionResource(id = R.dimen.padding_small))
                        .fillMaxWidth()
                        .clickable { isHobbyVisible = !isHobbyVisible },
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Image (
                        painter = painterResource(id = if(isHobbyVisible)  R.drawable.keyboard_arrow_up_24px else R.drawable.keyboard_arrow_down_24px),
                        contentDescription = "Keyboard arrow pointing down",
                    )
                }

            }
        }


    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewDogItem() {
        WoofTheme {
            val modifier = Modifier
            Surface(
                modifier = modifier
                    .fillMaxSize()
            ) {
                Show(
                    DataSourceDog.listDogs.get(0),
                    modifier
                )
            }
        }
    }


}

