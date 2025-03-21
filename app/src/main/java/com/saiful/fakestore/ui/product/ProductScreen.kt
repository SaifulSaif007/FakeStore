package com.saiful.fakestore.ui.product

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.saiful.fakestore.R
import com.saiful.fakestore.data.model.product.ProductResponse

@Composable
fun ProductScreen(productViewModel: ProductViewModel = viewModel()) {
    ProductScreenContent(viewModel = productViewModel)
}

@Composable
private fun ProductScreenContent(viewModel: ProductViewModel) {
    val products = viewModel.products.collectAsState()
    LazyColumn {
        items(count = products.value.size) {
            ProductItem(
                product = products.value[it]
            )
        }
    }

}

@Composable
private fun ProductItem(
    product: ProductResponse
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.image)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                error = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "product image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp, 120.dp),
            )
        }

        Column {
            Text(product.title)
            Text(product.description)

            Text("${product.price}")
            Text(product.category)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductPreview() {
    ProductScreenContent(viewModel = ProductViewModel())
}