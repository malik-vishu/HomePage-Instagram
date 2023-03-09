@file:SuppressLint("UnusedMaterialScaffoldPaddingParameter")

package com.example.instadmscreen.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instadmscreen.R
import com.example.instadmscreen.data.DM
import com.example.instadmscreen.data.DataSource
import com.example.instadmscreen.data.ImageAndText

@Preview(showSystemUi = true)
@Composable
fun MainScreen() {
    var tabSelected by remember {
        mutableStateOf(0)
    }

    Scaffold(bottomBar = {
        BottomBar() {
            tabSelected = it
        }
    }) {


        Column(modifier = Modifier) {
            when (tabSelected) {
                0 -> HomeTab()
            }


        }
    }


}

@Composable
fun HomeTab() {
    Column {
        TopBar()
        Surface(modifier = Modifier.fillMaxWidth()) {
            StoryImage(
                modifier = Modifier
                    .size(70.dp)
                    .border(1.dp, Color.LightGray, shape = CircleShape)
            )
        }
        PostHeadingRow()
        PostImage()
        PostBottomRow()
        PostText()
    }
}


//@Preview(showSystemUi = true)
@Composable
fun TopBar() {
    Surface(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(150.dp),
                    painter = painterResource(id = R.drawable.instalogo1),
                    contentDescription = "Instagram Logo"
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowDropDown,
                        contentDescription = "Drop Down Icon",
                        tint = Color.Black
                    )
                }
                Icon(
                    modifier = Modifier
                        .padding(start = 60.dp)
                        .size(33.dp),
                    imageVector = Icons.Outlined.AddBox,
                    contentDescription = "Add",
                    tint = Color.Black
                )
                Icon(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(33.dp),
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Liked",
                    tint = Color.Black
                )
                Icon(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(33.dp),
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Add",
                    tint = Color.Black
                )
            }
        }
    }
}

//@Preview(showSystemUi = true)
@Composable
fun StoryImage(
    modifier: Modifier = Modifier,
    listDM: List<DM> = DataSource().loadDmList()
) {
    Row {
        Column(
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = modifier
                    .size(70.dp)
                    .padding(5.dp),
                shape = CircleShape,
                elevation = 1.dp
            ) {

                Icon(imageVector = Icons.Outlined.PersonAdd, contentDescription = "Add Story Icon")


            }
            Text(
                text = "Your Story",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.caption.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
        LazyRow {
            items(listDM) {
                Column(
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(
                        modifier = modifier
                            .size(70.dp)
                            .padding(5.dp),
                        shape = CircleShape,
                        elevation = 1.dp
                    ) {

                        Image(
                            painter = painterResource(id = it.imageId),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                        )

                    }
                    Text(
                        text = it.name,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.caption.fontSize,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
        }
    }
}

//@Preview(showSystemUi = true)
@Composable
fun PostHeadingRow() {
    Surface(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 6.dp)
                    .size(34.dp)
                    .clip(shape = CircleShape),
                painter = painterResource(id = R.drawable.camerica),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                modifier = Modifier.padding(start = 6.dp),
                text = "captain",
                fontSize = MaterialTheme.typography.caption.fontSize
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.9f))
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Menu Icon"
            )

        }
    }
}

@Composable
fun PostImage() {
    Surface(modifier = Modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(top = 5.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.w1),
            contentDescription = "Watch Image"
        )
    }
}

@Composable
fun PostBottomRow() {
    Surface() {
        Row(
            modifier = Modifier.padding(top = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(34.dp)
                    .padding(start = 6.dp),
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "Like Icon"
            )
            Icon(
                modifier = Modifier
                    .size(28.dp)
                    .padding(start = 3.dp),
                painter = painterResource(id = R.drawable.comment_icon),
                contentDescription = "Comment Icon"
            )
            Icon(
                modifier = Modifier
                    .size(27.dp)
                    .padding(start = 4.dp),
                painter = painterResource(id = R.drawable.instagram_share_icon),
                contentDescription = "Send Icon"
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.9f))
            Icon(
                modifier = Modifier
                    .size(28.dp)
                    .padding(end = 3.dp),
                imageVector = Icons.Outlined.BookmarkBorder,
                contentDescription = "Bookmark Icon"
            )

        }
    }
}

@Composable
fun PostText() {
    Surface(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(start = 6.dp, top = 5.dp)) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Gray,
                            fontSize = MaterialTheme.typography.body2.fontSize
                        )
                    ) {
                        append(text = "Liked by ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = MaterialTheme.typography.body2.fontSize,
                            fontWeight = FontWeight.SemiBold
                        )
                    ) {
                        append(text = "20,000")
                    }
                })
            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontSize = MaterialTheme.typography.body2.fontSize,
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    append(text = "captain ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Gray,
                        fontSize = MaterialTheme.typography.body2.fontSize
                    )
                ) {
                    append(text = "Just added this to my collection")
                }
            })
        }
    }

}

@Composable
fun BottomBar(
    tabs: List<ImageAndText> = DataSource().mainScreenTabs(),
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    Surface(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = Color.Transparent,
            contentColor = Color.Black,
        ) {
            tabs.forEachIndexed { index, item ->
                Tab(
                    selected = selectedTabIndex == index,
                    selectedContentColor = Color.Black,
                    unselectedContentColor = inactiveColor,
                    onClick = {
                        selectedTabIndex = index
                        onTabSelected(index)
                    }
                ) {
                    if (item.icon != null) {
                        Icon(
                            imageVector = item.icon!!,
                            contentDescription = item.text,
                            tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                            modifier = Modifier
                                .padding(10.dp)
                                .size(20.dp)
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = item.image!!),
                            contentDescription = item.text,
                            tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                            modifier = Modifier
                                .padding(10.dp)
                                .size(20.dp)
                        )
                    }
                }
            }
        }
    }
}
