Inanimate
===================

Functional, Monadic Abstractions for the Minecraft World

## Synopsis

*Disclaimer: I am not good at Haskell, I just borrow its idea*

Currently in the stage of setting up.

The basic idea is that if in the real world, we have functions such as
```doHomework :: Homework -> IO ``` and all the homework from the week ```homeworks :: List```.
It would be wonderful if we could just ```mapM doHomework homeworks``` to finish all the homework
of the week instead of 
```doHomework englishHomework -- and so on for other homeworks```.

The good news ... is that this is entirely doable in Minecraft, as a mod to the miserable world
all Steves live in.

## Synopsis: Type System

```haskell
-- craft represents Minecraft's crafting system
-- it takes 9 nullable items and returns a Future Item
-- where Future is a monad similar to Haskell's IO
craft :: <Item?, 9> -> Future Item
```

```haskell
-- liftB represents a function that takes a function and makes it a "block"
liftB :: (a -> b) -> Block (a -> b)

-- for example, if you
liftB craft

-- then you should get the equivalent of a, guess what, crafting table
-- and just place the result in the world

-- how convenient
```