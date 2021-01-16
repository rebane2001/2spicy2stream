# 2spicy2stream
2spicy2stream (2s2s) is a mod that changes and censors offensive/NSFW Minecraft text and maps so that it is more suitable to livestream the game in a toxic community. 
Instead of just censoring toxic phrases, it sometimes replaces it with a similar phrase to retain context (eg `I hate you` -> `I disagree with you`).

## FAQ
### What is the goal of this project?
The goal of this project is to reduce the amount of offensive or NSFW content for streamers and content creators on servers such as 2b2t. It is not meant to remove 100% of said content - it's just something nice to have.
### Who is this project meant for?
This project is meant for streamers and content creators. It is not meant for people who simply wish to play, although there is nothing stopping you from using it.
### 2s2s can be easily bypassed by doing x!
Yes, there are many ways to bypass the filter, but the goal of the filter is to overall reduce offensive content, not block it all in its entirety.
### What wordlist does 2s2s use?
A modified version of [thepolitetype](https://www.thepolitetype.com/). This filter is not perfect at all, so feel free to submit suitable PRs.
### Can I use my own wordlist or modify the existing one?
Yes. At the moment you can edit the csv file by taking it out of the mod jar and putting it back later, but in a future update I plan to make it a separate file in your Minecraft directory so it can be easily changed at runtime.
### Can I censor everything instead of replacing phrases?
Yes, you can do so by disabling textReplace in the mod options.
### Which texts does 2s2s modify?
Pretty much all of them - chat, signs, books, nametags etc. 2s2s injects itself right into the FontRenderer class which is used by almost all of Minecraft.
### What does 2s2s do to maps?
Maps do not render their image at all. This can be turned off in the mod options separately from the text censoring.
### What if I still wish to see the original messages/maps?
You can turn off the censoring in the mod options. Additionally, you can bind a key to disable censoring while holding it.
### Does 2s2s affect performance?
Yes, but most of the time it is not noticable. If you have a lot of text rendering at once (such as a lot of signs), you may notice significant fps drops.
### Is this mod a joke?
No, at least not completely.