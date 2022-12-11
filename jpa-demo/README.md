# Items endpoint
To create an item using httpie
```
http POST :8080/items \
name=iPhone \
price=899
```

{"name": "iPhone","price": 899 }

To get all items
```
http :8080/items
```

