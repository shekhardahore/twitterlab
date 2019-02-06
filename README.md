# twitterlab
A demo twitter project

### Steps to run the project
1. Clone the repo.
2. Open the project in IntelliJ.
3. Download maven dependencies.
4. Replace your twitter API credentials in the `twitterlab-example.yml` and rename it to `twitterlab.yml`.
5. Run the project.

### Supported actions.

The project currently supports the following actions:
1. Get Twitter Timeline.
2. Post a Tweet.

To perform these actions:

#### Get Twitter Timeline:
Goto your browser and open: `http://localhost:8080/timeline`

#### Post a Tweet:
Run the follwing curl:
```curl -X POST \
  http://localhost:8080/publishTweet \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{"message": "<Your Tweet Here>"}'
  ```
