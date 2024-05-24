package com.stc.courses.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stc.courses.R
import com.stc.courses.data.DataSource
import com.stc.courses.model.CourseTopic
import com.stc.courses.ui.theme.CoursesTheme

class Home {
    @Composable
    fun DisplayTopic(courseTopic: CourseTopic) {
        Row(
            modifier = Modifier
                .height(68.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color(0xFFe5e0ea))
                ,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id =  courseTopic.imageResourceId),
                contentDescription = "photograph of ${courseTopic.nameResourceId}",
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp)

            )
            Column(
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
            ) {
                Text(
                    text = stringResource(id = courseTopic.nameResourceId),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "app icon"
                    )
                    Spacer( modifier = Modifier.width(8.dp))
                    Text(
                        text = courseTopic.associatedCoursesCount.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewDemo() {
        CoursesTheme {
            DisplayTopic(courseTopic = DataSource.listCourseTopics.first())
        }
    }
}


