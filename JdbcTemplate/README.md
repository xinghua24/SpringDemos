
user JdbcTemplate to insert, read, update, delete records.
```java

@Repository("userRepository")
public class UserRepositoryImnpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImnpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> list() {
        String sql = "SELECT id, name, email from users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    //...
}
```

JdbcTemplate.update() method does not return anything. However, it is useful to get back the id for the newly insert entity. keyHolder can be used to store the id of the new entity inserted into database.

```java
    @Override
    public void insertWithIdReturned(User user){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator(){
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(
                        "insert into users(name, email) values(?,?)", Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                return statement;
            }
        }, keyHolder);
        user.setId(keyHolder.getKey().intValue());
    }
```


Diff between RowMapper and ResultSetExtractor  
RowMapper executes once per row. ResultSetExtractor executes once per execution. ResultSetExtractor Example [http://www.javatpoint.com/ResultSetExtractor-example](http://www.javatpoint.com/ResultSetExtractor-example)