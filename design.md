#Description
Assess a Clojure library's "quality" based on different metrics. This will provide a means for potential library users to pick the "best" out of a field of alternatives.
#Determining Quality
Kibit  
Eastwood  
Cloverage  
#Data Flow
Datomic's method of defining a schema is pretty flexible: every datom in the database describes an entity-attribute-value relationship. Codeq provides us with the capability to interrogate a codebase at the function level of granularity, so we should be able to provide notes to the user at this same level of granularity.
The initial schema:
 - should enumerate the different categories of notes we'd like to see
 - a note, composed of:
   - the source of the note (e.g. a user, kibit, etc) [enumeration]
   - the line number or function associated with the note [reference to codeq datom]
   - the SHA associated with the note, to ensure it's still applicable [reference to codeq datom]
   - a flag [reference]
   - content [string]
   - comments associated with the note [reference]
   - current score [int]
 - comments
   - associated with a user [reference]
   - time [inst]
   - content [string]
   - current score [int]
   - a flag [reference]
 - users
   - first name [string]
   - last name [string]
   - email [string]
   - github handle [string]
   - OAuth access token [string]
 - a vote
   - up/down vote [enumeration]
   - the note/comment associated with the vote [reference]
   - the user associated with the vote [reference]
 - a flag
   - content (comment to go along with the flag) [string]
   - type of flag [enumeration]
   
#Milestones
##Initial
- Source file is displayed along with notes for this file.
User (and programs like kibit) can add notes to the file, similar to a comment in Atlassian's Stash, Fisheye, or github.
- github integration (a user logs in with their github account) (OAuth)
-The landing page has some number of popular Clojure libraries that they can check out.
- A library receives an overall score, based on different notes associated with the library, as well as other metrics, including test coverage.

##Plus
- A handful of categories for each note to reflect its nature (displayed differently in the UI to differentiate at a glance. Similar to github labels on issues.
- Be able to flag notes, especially autogenerated ones (e.g., from Kibit if it is nonsensical or a false positive). Users should be able to comment on notes and other comments as well.
- Take actions based on note categories (open a pull request with the suggested change, open an issue on github, etc)
- Users can upvote/downvote both notes and comments

##Dreamy
- Reputation: Users who have suggested or made many accepted changes will have more reputation to do different things on the site
