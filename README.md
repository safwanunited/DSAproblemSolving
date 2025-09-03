# Search API Example

This `curl` request demonstrates how to search, sort, and filter products.

```bash
curl --location 'http://localhost:8080/search/?query=iPhone&sortBy=PRICE_HIGH_TO_LOW&pageNumber=1&pageSize=10' \
--header 'Content-Type: application/json' \
--data '[
    {
        "key": "title",
        "values": ["iPhone 15 Pro", "iPhone Case"]
    },
    {
        "key": "category",
        "values": ["Smartphones", "Accessories"]
    },
    {
        "key": "brand",
        "values": ["Apple"]
    }
]'